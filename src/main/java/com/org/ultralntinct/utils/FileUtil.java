package com.org.ultralntinct.utils;

import jakarta.servlet.http.Part;

/**
 * <p>
 * The Class FileUtil.
 * </p>
 *
 * @author MinhNgoc
 */
public class FileUtil {

    /**
     * Gets the file name.
     *
     * @param part the part
     * @return the file name
     * @author MinhNgoc
     */
    public static String getFileName(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }

}
