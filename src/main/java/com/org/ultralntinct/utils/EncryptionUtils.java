package com.org.ultralntinct.utils;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/**
 * <p>
 * The Class EncryptionUtils.
 * </p>
 *
 * @author MinhNgoc
 */
public class EncryptionUtils {

    /** The secret key. */
    private static SecretKey secretKey;

    static {
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance(Constant.AES);
            keyGen.init(128);
            secretKey = keyGen.generateKey();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * *
     * <p>
     * The method Encrypt.
     * </p>
     *
     * @author MinhNgoc
     * @param data the data
     * @return the string
     */
    public static String encrypt(String data) {
        try {
            Cipher cipher = Cipher.getInstance(Constant.AES);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedData = cipher.doFinal(data.getBytes());
            return Base64.getEncoder().encodeToString(encryptedData);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * *
     * <p>
     * The method Decrypt.
     * </p>
     *
     * @author MinhNgoc
     * @param encryptedData the encrypted data
     * @return the string
     */
    public static String decrypt(String encryptedData) {
        try {
            Cipher cipher = Cipher.getInstance(Constant.AES);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decryptedData = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
            return new String(decryptedData);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Instantiates a new constant.
     */
    private EncryptionUtils() {
        throw new IllegalStateException("Utility class");
    }
}
