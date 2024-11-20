package com.michael.pranks.aws.service.impl;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.michael.pranks.aws.service.S3BucketService;
import java.io.File;
import org.springframework.stereotype.Service;

@Service
public class S3BucketServiceImpl implements S3BucketService {
  private final AmazonS3 amazonS3;

  public S3BucketServiceImpl(final AmazonS3 amazonS3) {
    this.amazonS3 = amazonS3;
  }

  @Override
  public String saveToBucket(final String bucketName, final String objectName, final File file) {
    amazonS3.putObject(bucketName, objectName, file);
    amazonS3.setObjectAcl(bucketName, objectName, CannedAccessControlList.PublicRead);
    return amazonS3.getUrl(bucketName, objectName).toString();
  }
}
