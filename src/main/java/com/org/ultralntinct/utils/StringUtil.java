package com.org.ultralntinct.utils;


public class StringUtil {

    public static String genCodeDiaChi(String code, String numberGen, int maxMaDiaChi) {
        StringBuilder codeFormat = new StringBuilder(code).append("%")
                      .append(numberGen).append("d");
        return String.format(codeFormat.toString(), maxMaDiaChi + 1);
    }

    private StringUtil () {
        throw new IllegalStateException("Utility class");
    }
}
