package com.org.ultralntinct.model;

import java.io.Serializable;
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
 * NhaCungCap class with table.
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
@Table(name = "NhaCungCap")
public class NhaCungCap implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The nha cung cap no. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nhaCungCapNo")
    private Long nhaCungCapNo;

    /** The ma nha cung cap. */
    @Column(name = "maNhaCungCap", unique = true)
    private String maNhaCungCap;

    /** The ten NCC. */
    @Column(name = "tenNCC")
    private String tenNCC;

    /** The so dien thoai. */
    @Column(name = "soDienThoai")
    private String soDienThoai;

    /** The email. */
    @Column(name = "email")
    private String email;

    /** The phieu nhap chi tiet list. */
    @OneToMany(mappedBy = "nhaCungCap")
    private List<PhieuNhapChiTiet> phieuNhapChiTietList;
}
