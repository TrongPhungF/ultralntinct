package com.org.ultralntinct.dao;

import java.sql.SQLException;
import java.util.List;

import com.org.ultralntinct.model.HoaDon;
import com.org.ultralntinct.model.HoaDonChiTiet;

/**
 * <p>
 * HoaDonDAO interface implements CRUDDao interface.
 * </p>
 *
 * @author MinhNgoc.
 */
public interface HoaDonDAO extends CRUDDao<HoaDon, Long> {

    /**
     * <p>
     * Method get max MaHoaDon.
     * </p>
     *
     * @return long.
     * @author MinhNgoc.
     */
    long getMaxMaSanPham() throws SQLException;

    /**
     * <p>
     * Save HoaDon with List of HoaDonChiTiet.
     * </p>
     *
     * @param hoaDon HoaDon.
     * @param hoaDonChiTietList of HoaDonChiTiet.
     * @author MinhNgoc
     * @throws SQLException 
     */
    void save(HoaDon hoaDon, List<HoaDonChiTiet> hoaDonChiTietList) throws SQLException;
//
//    /**
//     * <p>
//     * Method searchSanPham.
//     * </p>
//     *
//     * @param request SearchSanPhamRequest
//     * @return List of SanPham.
//     * @author MinhNgoc
//     */
//    List<SanPham> searchSanPham(SearchSanPhamRequest request);
}
