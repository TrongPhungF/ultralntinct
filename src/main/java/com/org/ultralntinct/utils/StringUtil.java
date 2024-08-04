package com.org.ultralntinct.utils;

import java.time.LocalDate;
import java.util.UUID;

/**
 * <p>
 * The Class StringUtil.
 * </p>
 *
 * @author MinhNgoc
 */
public class StringUtil {

    /**
     * *
     * <p>
     * The method Gen code dia chi.
     * </p>
     *
     * @author MinhNgoc
     * @param code        the code
     * @param numberGen   the number gen
     * @param maxMaDiaChi the max ma dia chi
     * @return the string
     */
    public static String genCode(String code) {
        StringBuilder codeFormat = new StringBuilder(code).append("-").append(LocalDate.now().toString()).append("-")
                .append(UUID.randomUUID());
        return codeFormat.toString();
    }

    /**
     * Instantiates a new string util.
     */
    private StringUtil () {
        throw new IllegalStateException("Utility class");
    }
}
