package com.michael.pranks.validators.handlers;

import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.michael.pranks.validators.annotations.Phone;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneNumberHandler implements ConstraintValidator<Phone, String> {
  @Override
  public boolean isValid(
      final String phoneNumber, final ConstraintValidatorContext constraintValidatorContext) {
    return PhoneNumberUtil.getInstance().isPossibleNumber(phoneNumber, "US");
  }
}
