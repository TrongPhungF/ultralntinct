package com.org.ultralntinct.dao.jpa;

import com.org.ultralntinct.model.LoaiSanPham;
import java.util.Optional;

/**
 * <p>
 * LoaiSanPhamDAO interface implements CRUDDao interface.
 * </p>
 *
 * @author MinhNgoc.
 */
public interface LoaiSanPhamDAO extends CrudDAO<LoaiSanPham, Long> {

    Optional<LoaiSanPham> findByMaLoaiSanPham(String maLoaiSanPham);

}
