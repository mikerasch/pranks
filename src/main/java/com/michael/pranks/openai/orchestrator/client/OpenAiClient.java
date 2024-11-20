package com.michael.pranks.openai.orchestrator.client;

import com.michael.pranks.openai.orchestrator.models.OpenAiRequest;
import org.springframework.ai.openai.audio.speech.SpeechResponse;

public interface OpenAiClient {
  SpeechResponse textToSpeech(OpenAiRequest openAiRequest);
}
