package com.org.ultralntinct.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * The Class UserSessionBuilder.
 * </p>
 *
 * @author MinhNgoc
 */
@Builder
@Setter
@Getter
@AllArgsConstructor
public class UserSession {

    /** The instance. */
    private static UserSession instance;

    /** The user name. */
    private String userName;

    /** The password. */
    private String password;

    /** The role. */
    private String role;

    /** The information. */
    private String information;

    /**
     * Instantiates a new user session.
     */
    private UserSession() {
    }

    /**
     * Gets the single instance of UserSession.
     *
     * @return single instance of UserSession
     */
    public static UserSession getInstance() {
        if (instance == null) {
            instance = new UserSession();
        }
        return instance;
    }
}
