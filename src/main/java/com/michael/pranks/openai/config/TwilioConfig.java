package com.michael.pranks.openai.config;

import com.twilio.Twilio;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TwilioConfig {
  public TwilioConfig(
      @Value("${twilio.account.sid}") final String twilioAccountSid,
      @Value("${twilio.auth.token}") final String twilioAuthToken) {
    Twilio.init(twilioAccountSid, twilioAuthToken);
  }
}
