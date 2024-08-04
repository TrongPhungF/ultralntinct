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
 * The Class S3Service.
 * </p>
 *
 * @author MinhNgoc
 */
@Log4j2
@AllArgsConstructor
public class S3Service {

    /** The s 3 client. */
    private S3Client s3Client;

    /** The s 3 presigner. */
    private S3Presigner s3Presigner;

    /** The aws config. */
    private AwsConfig awsConfig;

    /**
     * Instantiates a new s 3 service.
     */
    public S3Service() {
        this.awsConfig = new AwsConfig();
        this.s3Client = awsConfig.getS3Client();
        this.s3Presigner = awsConfig.getS3Presigner();
    }

    /**
     * *
     * <p>
     * The method Generate presigned url.
     * </p>
     *
     * @author MinhNgoc
     * @param value      the value
     * @param bucketName the bucket name
     * @return the string
     */
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

    /**
     * *
     * <p>
     * The method Generate presigned url.
     * </p>
     *
     * @author MinhNgoc
     * @param bucketName the bucket name
     * @param key        the key
     * @param duration   the duration
     * @return the string
     */
    // Generate a pre-signed URL for an object
    public String generatePresignedUrl(String bucketName, String key, Duration duration) {
        GetObjectPresignRequest getObjectPresignRequest = GetObjectPresignRequest.builder().signatureDuration(duration)
                .getObjectRequest(getObjectRequest -> getObjectRequest.bucket(bucketName).key(key)).build();
        PresignedGetObjectRequest presignedGetObjectRequest = s3Presigner.presignGetObject(getObjectPresignRequest);
        return presignedGetObjectRequest.url().toString();
    }

    /**
     * Checks if is exit S 3.
     *
     * @param bucketName the bucket name
     * @param key        the key
     * @return true, if is exit S 3
     * @author MinhNgoc
     */
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

    /**
     * <p>
     * The method Upload object.
     * </p>
     *
     * @author MinhNgoc
     * @param bucketName the bucket name
     * @param key        the key
     * @param file       the file
     */
    // Create (Upload) an object
    public void uploadObject(String bucketName, String key, File file) {
        PutObjectRequest putObjectRequest = PutObjectRequest.builder().bucket(bucketName).key(key).build();
        RequestBody requestBody = RequestBody.fromFile(file);
        s3Client.putObject(putObjectRequest, requestBody);
    }

    /**
     * <p>
     * The method Upload object.
     * </p>
     *
     * @author MinhNgoc
     * @param bucketName  the bucket name
     * @param key         the key
     * @param inputStream the input stream
     * @throws IOException Signals that an I/O exception has occurred.
     */
    // Create (Upload) an object
    public void uploadObject(String bucketName, String key, InputStream inputStream) throws IOException {
        byte[] contentBytes = inputStream.readAllBytes();
        PutObjectRequest putObjectRequest = PutObjectRequest.builder().bucket(bucketName).key(key).build();
        RequestBody requestBody = RequestBody.fromBytes(contentBytes);
        s3Client.putObject(putObjectRequest, requestBody);
    }

    /**
     * <p>
     * The method Delete object.
     * </p>
     *
     * @author MinhNgoc
     * @param bucketName the bucket name
     * @param key        the key
     */
    // Delete an object
    public void deleteObject(String bucketName, String key) {
        try {
            s3Client.deleteObject(DeleteObjectRequest.builder().bucket(bucketName).key(key).build());
        } catch (SdkException e) {
            e.printStackTrace();
        }
    }

    /**
     * *
     * <p>
     * The method List buckets.
     * </p>
     *
     * @author MinhNgoc
     * @return the list
     */
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
