package com.org.ultralntinct.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * UserSession class with table.
 * </p>
 *
 * @author MinhNgoc
 */
@Builder
@Setter
@Getter
@AllArgsConstructor
public class UserSession {

    private static UserSession instance;

    private String userName;
    private String password;
    private String role;
    private String information;

    private UserSession() {
    }

    public static UserSession getInstance() {
        if (instance == null) {
            instance = new UserSession();
        }
        return instance;
    }
}
