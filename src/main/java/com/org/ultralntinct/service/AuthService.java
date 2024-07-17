package com.org.ultralntinct.service;

import com.org.ultralntinct.dto.UserSession;

/**
 * <p>
 * AuthService interface implements CRUDDao interface.
 * </p>
 *
 * @author MinhNgoc
 */
public interface AuthService {

    UserSession logIn(String userName, String password);

    UserSession logOut();
}
