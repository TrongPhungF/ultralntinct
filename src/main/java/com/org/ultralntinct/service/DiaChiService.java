package com.org.ultralntinct.service;

import com.org.ultralntinct.dao.CRUDDao;
import com.org.ultralntinct.model.DiaChi;
import java.sql.SQLException;

/**
 * <p>
 * DiaChiService interface implements CRUDDao interface.
 * </p>
 *
 * @author MinhNgoc
 */
public interface DiaChiService extends CRUDDao<DiaChi, Long> {

    /**
     * <p>
     * Method get max MaDiaChi
     * </p>
     *
     * @return long.
     * @author MinhNgoc
     */
    long getMaxMaDiaChi() throws SQLException;
}
