package com.michael.pranks.openai.orchestrator.client.impl;

import com.michael.pranks.openai.orchestrator.client.OpenAiClient;
import com.michael.pranks.openai.orchestrator.models.OpenAiRequest;
import org.springframework.ai.openai.OpenAiAudioSpeechModel;
import org.springframework.ai.openai.OpenAiAudioSpeechOptions;
import org.springframework.ai.openai.audio.speech.SpeechPrompt;
import org.springframework.ai.openai.audio.speech.SpeechResponse;
import org.springframework.stereotype.Component;

@Component
public class OpenAiClientImpl implements OpenAiClient {
  private final OpenAiAudioSpeechOptions.Builder openSpeechBuilder;
  private final OpenAiAudioSpeechModel speechModel;

  public OpenAiClientImpl(
      final OpenAiAudioSpeechOptions.Builder openSpeechBuilder,
      final OpenAiAudioSpeechModel speechModel) {
    this.openSpeechBuilder = openSpeechBuilder;
    this.speechModel = speechModel;
  }

  @Override
  public SpeechResponse textToSpeech(final OpenAiRequest openAiRequest) {
    OpenAiAudioSpeechOptions speechOptions =
        openSpeechBuilder.withVoice(openAiRequest.voice()).build();

    var speechPrompt = new SpeechPrompt(openAiRequest.message(), speechOptions);

    return speechModel.call(speechPrompt);
  }
}
