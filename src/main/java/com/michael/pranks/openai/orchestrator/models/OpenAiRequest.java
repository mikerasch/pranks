package com.michael.pranks.openai.orchestrator.models;

import org.springframework.ai.openai.api.OpenAiAudioApi;

public record OpenAiRequest(String message, OpenAiAudioApi.SpeechRequest.Voice voice) {}
