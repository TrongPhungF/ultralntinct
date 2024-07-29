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
 * PhieuNhapChiTiet class with table.
 * </p>
 *
 * @author MinhNgoc
 */
@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PhieuNhapChiTiet")
public class PhieuNhapChiTiet implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pNCTNo")
    private Long pNCTNo;

    @Column(name = "maPNCT", unique = true)
    private String maPNCT;

    @Column(name = "giaNhap")
    private BigDecimal giaNhap;

    @Column(name = "soLuong")
    private int soLuong;

    @ManyToOne
    @JoinColumn(name = "maSanPham", referencedColumnName = "maSanPham")
    private SanPham sanPham;

    @ManyToOne
    @JoinColumn(name = "maNhaCungCap", referencedColumnName = "maNhaCungCap")
    private NhaCungCap nhaCungCap;

    @ManyToOne
    @JoinColumn(name = "maNhapKho", referencedColumnName = "maNhapKho")
    private NhapKho nhapKho;
}
