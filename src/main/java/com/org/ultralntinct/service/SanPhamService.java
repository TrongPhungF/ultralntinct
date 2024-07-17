package com.org.ultralntinct.service;

import com.org.ultralntinct.dao.CRUDDao;
import com.org.ultralntinct.model.SanPham;
import com.org.ultralntinct.request.SearchSanPhamRequest;
import java.sql.SQLException;
import java.util.List;

/**
 * <p>
 * SanPhamService interface implements CRUDDao interface.
 * </p>
 *
 * @author MinhNgoc
 */
public interface SanPhamService extends CRUDDao<SanPham, Long> {

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
     * @param request SearchSanPhamRequest
     * @return List of SanPham.
     * @author MinhNgoc
     */
    List<SanPham> searchSanPham(SearchSanPhamRequest request);
}
