package com.org.ultralntinct.dao.jpa;

import java.sql.SQLException;
import java.util.List;

import com.org.ultralntinct.model.SanPham;
import com.org.ultralntinct.request.SearchSanPhamRequest;

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
     * @param request
     *            SearchSanPhamRequest
     * @return List of SanPham.
     * @author MinhNgoc
     */
    List<SanPham> searchSanPham(SearchSanPhamRequest request);
}
