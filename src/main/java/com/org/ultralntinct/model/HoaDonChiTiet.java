package com.org.ultralntinct.model;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * <p>
 * HoaDonChiTiet class with table.
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
@Table(name = "HoaDonChiTiet")
public class HoaDonChiTiet implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The h DCT no. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HDCTNo")
    private Long hDCTNo;

    /** The ma HDCT. */
    @Column(name = "maHDCT", unique = true)
    private String maHDCT;

    /** The gia ban. */
    @Column(name = "giaBan")
    private BigDecimal giaBan;

    /** The so luong. */
    @Column(name = "soLuong")
    private int soLuong;

    /** The ghi chu. */
    @Column(name = "ghiChu")
    private String ghiChu;

    /** The san pham. */
    @ManyToOne
    @JoinColumn(name = "maSanPham", referencedColumnName = "maSanPham")
    private SanPham sanPham;

    /** The hoa don. */
    @ManyToOne
    @JoinColumn(name = "maHoaDon", referencedColumnName = "maHoaDon")
    private HoaDon hoaDon;
}
