package com.org.ultralntinct.dao.jpa;

import com.org.ultralntinct.dto.UserSession;

/**
 * <p>
 * AuthDAO interface implements CRUDDao interface.
 * </p>
 *
 * @author MinhNgoc
 */
public interface AuthDAO {

    /**
     * *
     * <p>
     * The method Log in.
     * </p>
     *
     * @author MinhNgoc
     * @param userName the user name
     * @param password the password
     * @return the user session
     */
    UserSession logIn(String userName, String password);

    /**
     * *
     * <p>
     * The method Log out.
     * </p>
     *
     * @author MinhNgoc
     * @return the user session
     */
    UserSession logOut();
}
