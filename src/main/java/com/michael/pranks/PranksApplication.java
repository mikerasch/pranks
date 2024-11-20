package com.michael.pranks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PranksApplication {

  public static void main(String[] args) {
    disablePropertiesOnStart();
    SpringApplication.run(PranksApplication.class, args);
  }

  private static void disablePropertiesOnStart() {
    System.setProperty("aws.java.v1.disableDeprecationAnnouncement", "true");
  }
}
