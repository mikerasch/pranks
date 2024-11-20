package com.michael.pranks.phone.models;

import com.michael.pranks.validators.annotations.Phone;
import org.springframework.ai.openai.api.OpenAiAudioApi;

public record PhoneCallRequest(
    @Phone String fromPhoneNumber,
    @Phone String toPhoneNumber,
    String message,
    OpenAiAudioApi.SpeechRequest.Voice voice) {}
