package com.michael.pranks.phone.service.impl;

import com.michael.pranks.aws.service.S3BucketService;
import com.michael.pranks.openai.orchestrator.models.OpenAiRequest;
import com.michael.pranks.openai.orchestrator.service.OpenAiTextToSpeechOrchestrator;
import com.michael.pranks.phone.models.CallProviderRequest;
import com.michael.pranks.phone.models.PhoneCallRequest;
import com.michael.pranks.phone.service.PhoneCallService;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;
import org.springframework.ai.openai.audio.speech.SpeechResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PhoneCallServiceImpl implements PhoneCallService {
  @Value("${amazon.s3.mp3.bucket}")
  private String amazonS3Mp3Bucket;

  private final OpenAiTextToSpeechOrchestrator openAiTextToSpeechOrchestrator;
  private final S3BucketService s3BucketService;
  private final TwilioCallProvider twilioCallOrchestrator;

  public PhoneCallServiceImpl(
      final OpenAiTextToSpeechOrchestrator openAiTextToSpeechOrchestrator,
      final S3BucketService s3BucketService,
      final TwilioCallProvider twilioCallOrchestrator) {
    this.openAiTextToSpeechOrchestrator = openAiTextToSpeechOrchestrator;
    this.s3BucketService = s3BucketService;
    this.twilioCallOrchestrator = twilioCallOrchestrator;
  }

  @Override
  public void makePhoneCall(final PhoneCallRequest phoneCallRequest) {
    var openAiRequest = new OpenAiRequest(phoneCallRequest.message(), phoneCallRequest.voice());

    SpeechResponse speechResponse = openAiTextToSpeechOrchestrator.textToSpeech(openAiRequest);
    File tempFile = createTempMp3File(speechResponse.getResult().getOutput());

    String url =
        s3BucketService.saveToBucket(amazonS3Mp3Bucket, UUID.randomUUID().toString(), tempFile);

    twilioCallOrchestrator.makePhoneCall(
        new CallProviderRequest(
            phoneCallRequest.fromPhoneNumber(), phoneCallRequest.toPhoneNumber(), url));
  }

  private File createTempMp3File(byte[] output) {
    try {
      Path tempFilePath = Files.createTempFile("tempAudio", ".mp3");
      try (FileOutputStream fos = new FileOutputStream(tempFilePath.toFile())) {
        fos.write(output);
      }
      return tempFilePath.toFile();
    } catch (IOException e) {
      return null;
    }
  }
}
