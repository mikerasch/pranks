package com.michael.pranks.phone.service;

import com.michael.pranks.phone.models.CallProviderRequest;

public interface PhoneCallProvider {
  void makePhoneCall(CallProviderRequest callProviderRequest);
}
