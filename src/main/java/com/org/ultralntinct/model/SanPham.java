package com.org.ultralntinct.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * <p>
 * SanPham class with table.
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
@Table(name = "SanPham")
public class SanPham implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sanPhamNo")
    private Long sanPhamNo;

    @Column(name = "maSanPham",unique = true)
    private String maSanPham;

    @Column(name = "tenSanPham")
    private String tenSanPham;

    @Column(name = "giaNiemYet")
    private BigDecimal giaNiemYet;

    @Column(name = "soLuongTon")
    private int soLuongTon;

    @Column(name = "hinh")
    private String hinh;

    @ManyToOne
    @JoinColumn(name = "maLoaiSanPham", referencedColumnName = "maLoaiSanPham")
    private LoaiSanPham loaiSanPham;

    @OneToMany(mappedBy = "sanPham")
    private List<HoaDonChiTiet> hoaDonChiTietList;

    @OneToMany(mappedBy = "sanPham")
    private List<PhieuNhapChiTiet> phieuNhapChiTietList;

}
