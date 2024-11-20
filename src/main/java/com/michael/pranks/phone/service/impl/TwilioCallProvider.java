package com.michael.pranks.phone.service.impl;

import com.michael.pranks.phone.models.CallProviderRequest;
import com.michael.pranks.phone.service.PhoneCallProvider;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.type.PhoneNumber;
import com.twilio.type.Twiml;
import org.springframework.stereotype.Service;

@Service
public class TwilioCallProvider implements PhoneCallProvider {
  private static final String TWIML_PLAYBACK_FORMAT = "<Response><Play>%s</Play></Response>";

  @Override
  public void makePhoneCall(final CallProviderRequest callProviderRequest) {
    Call.creator(
            new PhoneNumber(callProviderRequest.fromPhoneNumber()),
            new PhoneNumber(callProviderRequest.toPhoneNumber()),
            new Twiml(TWIML_PLAYBACK_FORMAT.formatted(callProviderRequest.mp3Url())))
        .create();
  }
}
