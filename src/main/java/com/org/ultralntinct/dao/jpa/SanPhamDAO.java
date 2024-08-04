package com.org.ultralntinct.dao.jpa;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

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
     * @author MinhNgoc.
     * @return long.
     * @throws SQLException the SQL exception
     */
    long getMaxMaSanPham() throws SQLException;

    /**
     * <p>
     * Method searchSanPham.
     * </p>
     *
     * @author MinhNgoc
     * @param keySearch String
     * @return List of SanPham.
     */
    List<SanPham> searchSanPham(String keySearch);

    /**
     * *
     * <p>
     * The method Find by ma san pham.
     * </p>
     *
     * @author MinhNgoc
     * @param maSanPham the ma san pham
     * @return the optional
     */
    Optional<SanPham> findByMaSanPham(String maSanPham);

    /**
     * *
     * <p>
     * The method deleteByMaSanPham.
     * </p>
     *
     * @author MinhNgoc
     * @param maSanPham the ma san pham
     */
    void deleteByMaSanPham(String maSanPham);
}
