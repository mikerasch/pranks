package com.michael.pranks.openai.options.models;

import java.util.List;
import org.springframework.ai.openai.api.OpenAiAudioApi;

public record OpenAiVoices(List<OpenAiAudioApi.SpeechRequest.Voice> voices) {}
