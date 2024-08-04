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
 * PhieuNhapChiTiet class with table.
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
@Table(name = "PhieuNhapChiTiet")
public class PhieuNhapChiTiet implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The p NCT no. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pNCTNo")
    private Long pNCTNo;

    /** The ma PNCT. */
    @Column(name = "maPNCT", unique = true)
    private String maPNCT;

    /** The gia nhap. */
    @Column(name = "giaNhap")
    private BigDecimal giaNhap;

    /** The so luong. */
    @Column(name = "soLuong")
    private int soLuong;

    /** The san pham. */
    @ManyToOne
    @JoinColumn(name = "maSanPham", referencedColumnName = "maSanPham")
    private SanPham sanPham;

    /** The nha cung cap. */
    @ManyToOne
    @JoinColumn(name = "maNhaCungCap", referencedColumnName = "maNhaCungCap")
    private NhaCungCap nhaCungCap;

    /** The nhap kho. */
    @ManyToOne
    @JoinColumn(name = "maNhapKho", referencedColumnName = "maNhapKho")
    private NhapKho nhapKho;
}
