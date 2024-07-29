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
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * <p>
 * HoaDonChiTiet class with table.
 * </p>
 *
 * @author MinhNgoc
 */
@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "HoaDonChiTiet")
public class HoaDonChiTiet implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hDCTNo")
    private Long hDCTNo;

    @Column(name = "maHDCT", unique = true)
    private String maHDCT;

    @Column(name = "giaBan")
    private BigDecimal giaBan;

    @Column(name = "soLuong")
    private int soLuong;

    @Column(name = "ghiChu")
    private String ghiChu;

    @ManyToOne
    @JoinColumn(name = "maSanPham", referencedColumnName = "maSanPham")
    private SanPham sanPham;

    @ManyToOne
    @JoinColumn(name = "maHoaDon", referencedColumnName = "maHoaDon")
    private HoaDon hoaDon;
}
