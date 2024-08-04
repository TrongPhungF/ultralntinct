package com.org.ultralntinct.model;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * <p>
 * NhapKho class with table.
 * </p>
 *
 * @author MinhNgoc
 */
@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "NhapKho")
public class NhapKho implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The nhap kho no. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nhapKhoNo")
    private Long nhapKhoNo;

    /** The ma nhap kho. */
    @Column(name = "maNhapKho", unique = true)
    private String maNhapKho;

    /** The ngay nhap. */
    @Column(name = "ngayNhap")
    private LocalDateTime ngayNhap;

    /** The trang thai. */
    @Column(name = "trangThai")
    private boolean trangThai;

    /** The phieu nhap chi tiet list. */
    @OneToMany(mappedBy = "nhapKho")
    private List<PhieuNhapChiTiet> phieuNhapChiTietList;
}
