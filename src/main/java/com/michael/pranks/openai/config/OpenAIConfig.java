package com.michael.pranks.openai.config;

import org.springframework.ai.openai.OpenAiAudioSpeechModel;
import org.springframework.ai.openai.OpenAiAudioSpeechOptions;
import org.springframework.ai.openai.api.OpenAiAudioApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAIConfig {
  @Value("${spring.ai.openai.api-key}")
  private String openAIApiKey;

  @Bean
  public OpenAiAudioSpeechOptions.Builder defaultAudioSpeechOptionsBuilder() {
    return OpenAiAudioSpeechOptions.builder()
        .withSpeed(1F)
        .withResponseFormat(OpenAiAudioApi.SpeechRequest.AudioResponseFormat.MP3)
        .withModel(OpenAiAudioApi.TtsModel.TTS_1.value);
  }

  @Bean
  public OpenAiAudioSpeechModel openAiAudioSpeechModel() {
    var openAiAudioAPi = new OpenAiAudioApi(openAIApiKey);

    return new OpenAiAudioSpeechModel(openAiAudioAPi);
  }
}
