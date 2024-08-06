package com.org.ultralntinct.dao.jpa;

import java.util.Optional;

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
     * Method findByMaKhachHang.
     * </p>
     *
     * @param maKhachHang String
     *
     * @return KhachHang.
     *
     * @author MinhNgoc.
     */
    Optional<KhachHang> findByMaKhachHang(String maKhachHang);
}
