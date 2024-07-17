package com.org.ultralntinct.service;

import java.sql.SQLException;

import com.org.ultralntinct.dao.CRUDDao;
import com.org.ultralntinct.model.NhanVien;

/**
 * <p>
 * NhanVienService interface implements CRUDDao interface.
 * </p>
 *
 * @author MinhNgoc
 */
public interface NhanVienService extends CRUDDao<NhanVien, Long> {

    /**
     * <p>
     * Method get max MaNhanVien.
     * </p>
     *
     * @return long.
     * @author MinhNgoc.
     */
    long getMaxMaNhanVien() throws SQLException;
}
