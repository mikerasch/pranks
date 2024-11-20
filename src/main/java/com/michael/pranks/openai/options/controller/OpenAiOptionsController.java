package com.michael.pranks.openai.options.controller;

import com.michael.pranks.openai.options.models.OpenAiVoices;
import com.michael.pranks.openai.options.service.OpenAiOptionsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OpenAiOptionsController {
  private final OpenAiOptionsService openAiOptionsService;

  public OpenAiOptionsController(final OpenAiOptionsService openAiOptionsService) {
    this.openAiOptionsService = openAiOptionsService;
  }

  @GetMapping("/voices")
  public OpenAiVoices fetchAllOpenAiVoices() {
    return openAiOptionsService.fetchAllOpenAiVoices();
  }
}
