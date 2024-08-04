package com.org.ultralntinct.utils;


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
    public static String genCodeDiaChi(String code, String numberGen, int maxMaDiaChi) {
        StringBuilder codeFormat = new StringBuilder(code).append("%")
                      .append(numberGen).append("d");
        return String.format(codeFormat.toString(), maxMaDiaChi + 1);
    }

    /**
     * Instantiates a new string util.
     */
    private StringUtil () {
        throw new IllegalStateException("Utility class");
    }
}
