package com.michael.pranks.phone.controller;

import com.michael.pranks.phone.models.PhoneCallRequest;
import com.michael.pranks.phone.service.PhoneCallService;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/phone-calls")
@Validated
public class PhoneCallController {
  private final PhoneCallService phoneCallService;

  public PhoneCallController(final PhoneCallService phoneCallService) {
    this.phoneCallService = phoneCallService;
  }

  @PostMapping
  public void makePhoneCall(@RequestBody @Valid final PhoneCallRequest phoneCallRequest) {
    phoneCallService.makePhoneCall(phoneCallRequest);
  }
}
