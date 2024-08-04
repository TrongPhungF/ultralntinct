package com.org.ultralntinct.dao.jpa;

import java.util.Optional;

import com.org.ultralntinct.model.LoaiSanPham;

/**
 * <p>
 * LoaiSanPhamDAO interface implements CRUDDao interface.
 * </p>
 *
 * @author MinhNgoc.
 */
public interface LoaiSanPhamDAO extends CrudDAO<LoaiSanPham, Long> {

    /**
     * *
     * <p>
     * The method Find by ma loai san pham.
     * </p>
     *
     * @author MinhNgoc
     * @param maLoaiSanPham the ma loai san pham
     * @return the optional
     */
    Optional<LoaiSanPham> findByMaLoaiSanPham(String maLoaiSanPham);

}
