package com.michael.pranks.openai.orchestrator.service;

import com.michael.pranks.openai.orchestrator.client.OpenAiClient;
import com.michael.pranks.openai.orchestrator.models.OpenAiRequest;
import org.springframework.ai.openai.audio.speech.SpeechResponse;
import org.springframework.stereotype.Service;

@Service
public class OpenAiTextToSpeechOrchestrator {
  private final OpenAiClient openAiClient;

  public OpenAiTextToSpeechOrchestrator(final OpenAiClient openAiClient) {
    this.openAiClient = openAiClient;
  }

  public SpeechResponse textToSpeech(final OpenAiRequest openAiRequest) {
    return openAiClient.textToSpeech(openAiRequest);
  }
}
