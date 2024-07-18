package com.org.ultralntinct.dao;

import com.org.ultralntinct.model.DiaChi;
import java.sql.SQLException;

/**
 * <p>
 * DiaChiDAO interface implements CRUDDao interface.
 * </p>
 *
 * @author MinhNgoc
 */
public interface DiaChiDAO extends CRUDDao<DiaChi, Long> {

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
