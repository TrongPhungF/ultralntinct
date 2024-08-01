package com.org.ultralntinct.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.org.ultralntinct.config.AwsConfig;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import software.amazon.awssdk.core.exception.SdkException;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.Bucket;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;
import software.amazon.awssdk.services.s3.model.HeadObjectRequest;
import software.amazon.awssdk.services.s3.model.ListBucketsResponse;
import software.amazon.awssdk.services.s3.model.NoSuchKeyException;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import software.amazon.awssdk.services.s3.presigner.model.GetObjectPresignRequest;
import software.amazon.awssdk.services.s3.presigner.model.PresignedGetObjectRequest;

/**
 * <p>
 * S3Service class.
 * </p>
 *
 * @author MinhNgoc.
 */
@Log4j2
@AllArgsConstructor
public class S3Service {

    private S3Client s3Client;

    private S3Presigner s3Presigner;

    private AwsConfig awsConfig;

    public S3Service() {
        this.awsConfig = new AwsConfig();
        this.s3Client = awsConfig.getS3Client();
        this.s3Presigner = awsConfig.getS3Presigner();
    }

    public String generatePresignedUrl(String value, String bucketName) {
        if (StringUtils.isNotBlank(value)) {
            String filePathPrefix = bucketName + "/";
            String key = value;
            if (value.startsWith(filePathPrefix)) {
                key = value.substring(filePathPrefix.length());
            }
            if (isExitS3(bucketName, key)) {
                return generatePresignedUrl(bucketName, key, Duration.ofHours(24));
            }
        }
        return StringUtils.EMPTY;
    }

    // Generate a pre-signed URL for an object
    public String generatePresignedUrl(String bucketName, String key, Duration duration) {
        GetObjectPresignRequest getObjectPresignRequest = GetObjectPresignRequest.builder().signatureDuration(duration)
                .getObjectRequest(getObjectRequest -> getObjectRequest.bucket(bucketName).key(key)).build();
        PresignedGetObjectRequest presignedGetObjectRequest = s3Presigner.presignGetObject(getObjectPresignRequest);
        return presignedGetObjectRequest.url().toString();
    }

    public boolean isExitS3(String bucketName, String key) {
        try {
            HeadObjectRequest headObjectRequest = HeadObjectRequest.builder().bucket(bucketName).key(key).build();
            s3Client.headObject(headObjectRequest);
            return true;
        } catch (NoSuchKeyException e) {
            log.info(e);
            return false;
        }
    }

    // Create (Upload) an object
    public void uploadObject(String bucketName, String key, File file) {
        PutObjectRequest putObjectRequest = PutObjectRequest.builder().bucket(bucketName).key(key).build();
        RequestBody requestBody = RequestBody.fromFile(file);
        s3Client.putObject(putObjectRequest, requestBody);
    }

    // Create (Upload) an object
    public void uploadObject(String bucketName, String key, InputStream inputStream) throws IOException {
        byte[] contentBytes = inputStream.readAllBytes();
        long contentLength = contentBytes.length;
        PutObjectRequest putObjectRequest = PutObjectRequest.builder().bucket(bucketName).key(key).build();
        RequestBody requestBody = RequestBody.fromBytes(contentBytes);
        s3Client.putObject(putObjectRequest, requestBody);
    }

    // Delete an object
    public void deleteObject(String bucketName, String key) {
        try {
            s3Client.deleteObject(DeleteObjectRequest.builder().bucket(bucketName).key(key).build());
        } catch (SdkException e) {
            e.printStackTrace();
        }
    }

    // List all buckets
    public List<Bucket> listBuckets() {
        try {
            ListBucketsResponse listBucketsResponse = s3Client.listBuckets();
            return listBucketsResponse.buckets();
        } catch (SdkException e) {
            e.printStackTrace();
            return null;
        }
    }
}
