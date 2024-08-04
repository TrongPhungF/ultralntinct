package com.org.ultralntinct.dao.jpa;

import java.util.Optional;

import com.org.ultralntinct.model.NhanVien;

/**
 * <p>
 * NhanVienDAO interface implements CRUDDao interface.
 * </p>
 *
 * @author MinhNgoc.
 */
public interface NhanVienDAO extends CrudDAO<NhanVien, Long> {

    /**
     * *
     * <p>
     * The method Find by ma nhan vien.
     * </p>
     *
     * @author MinhNgoc
     * @param maNhanVien the ma nhan vien
     * @return the optional
     */
	Optional<NhanVien> findByMaNhanVien(String maNhanVien);
}
