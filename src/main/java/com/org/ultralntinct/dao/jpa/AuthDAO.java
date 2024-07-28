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

    UserSession logIn(String userName, String password);

    UserSession logOut();
}
