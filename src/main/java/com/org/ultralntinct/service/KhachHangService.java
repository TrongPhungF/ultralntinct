package com.org.ultralntinct.service;

import java.sql.SQLException;

import com.org.ultralntinct.dao.CRUDDao;
import com.org.ultralntinct.model.KhachHang;

/**
 * <p>
 * KhachHangService interface implements CRUDDao interface.
 * </p>
 *
 * @author MinhNgoc
 */
public interface KhachHangService extends CRUDDao<KhachHang, Long> {

    /**
     * <p>
     * Method get max MaKhachHang.
     * </p>
     *
     * @return long.
     * @author MinhNgoc.
     */
    long getMaxMaSanPham() throws SQLException;
}
