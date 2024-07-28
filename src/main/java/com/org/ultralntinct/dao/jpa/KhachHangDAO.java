package com.org.ultralntinct.dao.jpa;

import java.sql.SQLException;

import com.org.ultralntinct.model.KhachHang;

/**
 * <p>
 * KhachHangDAO interface implements CRUDDao interface.
 * </p>
 *
 * @author MinhNgoc.
 */
public interface KhachHangDAO extends CrudDAO<KhachHang, Long> {

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
