package com.michael.pranks.aws.service;

import java.io.File;

public interface S3BucketService {
  String saveToBucket(String bucketName, String objectName, File file);
}
