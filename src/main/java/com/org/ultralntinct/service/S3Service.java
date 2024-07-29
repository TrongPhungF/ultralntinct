package com.org.ultralntinct.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;

import lombok.AllArgsConstructor;
import software.amazon.awssdk.core.exception.SdkException;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.Bucket;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;
import software.amazon.awssdk.services.s3.model.ListBucketsResponse;
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
 * 
 */
@AllArgsConstructor
public class S3Service {

    private final S3Client s3Client;

    private final S3Presigner s3Presigner;

    // Create (Upload) an object
    public void uploadObject(String bucketName, String key, String filePath) {
        try {
            s3Client.putObject(PutObjectRequest.builder().bucket(bucketName).key(key).build(),
                    RequestBody.fromBytes(Files.readAllBytes(Paths.get(filePath))));
            System.out.println("File uploaded successfully.");
        } catch (IOException | SdkException e) {
            e.printStackTrace();
        }
    }

    // Read (Download) an object
    public void downloadObject(String bucketName, String key, String downloadFilePath) {
        try {
            GetObjectResponse getObjectResponse = s3Client.getObject(
                    GetObjectRequest.builder().bucket(bucketName).key(key).build(), Paths.get(downloadFilePath));
            System.out.println("File downloaded successfully.");
        } catch (SdkException e) {
            e.printStackTrace();
        }
    }

    // Update an object (essentially re-uploading it)
    public void updateObject(String bucketName, String key, String newFilePath) {
        uploadObject(bucketName, key, newFilePath);
        System.out.println("File updated successfully.");
    }

    // Delete an object
    public void deleteObject(String bucketName, String key) {
        try {
            s3Client.deleteObject(DeleteObjectRequest.builder().bucket(bucketName).key(key).build());
            System.out.println("File deleted successfully.");
        } catch (SdkException e) {
            e.printStackTrace();
        }
    }

    // Generate a pre-signed URL for an object
    public String generatePresignedUrl(String bucketName, String key, Duration duration) {
        try {
            PresignedGetObjectRequest presignedGetObjectRequest = s3Presigner.presignGetObject(GetObjectPresignRequest
                    .builder().getObjectRequest(GetObjectRequest.builder().bucket(bucketName).key(key).build())
                    .signatureDuration(duration).build());
            return presignedGetObjectRequest.url().toString();
        } catch (SdkException e) {
            e.printStackTrace();
            return null;
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
