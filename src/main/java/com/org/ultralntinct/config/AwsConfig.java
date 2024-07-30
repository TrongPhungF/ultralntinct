package com.org.ultralntinct.config;

import io.github.cdimascio.dotenv.Dotenv;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;

/**
 * <p>
 * AwsConfig class.
 * </p>
 * 
 * @author MinhNgoc.
 * 
 */
public class AwsConfig {

    /** credentialsProvider */
    private final StaticCredentialsProvider credentialsProvider;

    /** region */
    private final Region region;

    /**
     * <p>
     * Constructor AwsConfig.
     * </p>
     *
     * @author MinhNgoc.
     */
    public AwsConfig() {
        Dotenv dotenv = Dotenv.load();
        this.region = Region.of(dotenv.get("AWS_CLOUD_REGION"));
        AwsBasicCredentials awsCreds = AwsBasicCredentials.create(
                dotenv.get("AWS_CLOUD_S3_ACCESS_KEY_ID"),
                dotenv.get("AWS_CLOUD_S3_SECRET_ACCESS_KEY"));
        this.credentialsProvider = StaticCredentialsProvider.create(awsCreds);
    }

    /**
     * <p>
     * Get S3 Client.
     * </p>
     *
     * @author MinhNgoc.
     */
    public S3Client getS3Client() {
        return S3Client.builder().region(region)
                .credentialsProvider(credentialsProvider).build();
    }
    
    /**
     * <p>
     * Get S3 Presigner.
     * </p>
     * @author MinhNgoc.
     */
    public S3Presigner getS3Presigner() {
        return S3Presigner.builder()
                .region(region)
                .credentialsProvider(credentialsProvider)
                .build();
    }
}
