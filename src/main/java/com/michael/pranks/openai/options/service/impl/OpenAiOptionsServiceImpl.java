package com.michael.pranks.openai.options.service.impl;

import com.michael.pranks.openai.options.models.OpenAiVoices;
import com.michael.pranks.openai.options.service.OpenAiOptionsService;
import java.util.Arrays;
import java.util.List;
import org.springframework.ai.openai.api.OpenAiAudioApi;
import org.springframework.stereotype.Service;

@Service
public class OpenAiOptionsServiceImpl implements OpenAiOptionsService {

  @Override
  public OpenAiVoices fetchAllOpenAiVoices() {
    List<OpenAiAudioApi.SpeechRequest.Voice> supportedVoices =
        Arrays.stream(OpenAiAudioApi.SpeechRequest.Voice.values()).toList();
    return new OpenAiVoices(supportedVoices);
  }
}
