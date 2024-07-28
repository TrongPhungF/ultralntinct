package com.org.ultralntinct.dao.jpa;

import java.sql.SQLException;
import java.util.List;

import com.org.ultralntinct.model.SanPham;

/**
 * <p>
 * SanPhamDAO interface implements CRUDDao interface.
 * </p>
 *
 * @author MinhNgoc.
 */
public interface SanPhamDAO extends CrudDAO<SanPham, Long> {

    /**
     * <p>
     * Method get max MaSanPham.
     * </p>
     *
     * @return long.
     * @author MinhNgoc.
     */
    long getMaxMaSanPham() throws SQLException;

    /**
     * <p>
     * Method searchSanPham.
     * </p>
     *
     * @param keySearch
     *            String
     * @return List of SanPham.
     * @author MinhNgoc
     */
    List<SanPham> searchSanPham(String keySearch);
}
