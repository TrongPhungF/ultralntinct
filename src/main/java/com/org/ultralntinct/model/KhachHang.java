package com.org.ultralntinct.model;

import java.io.Serializable;
import java.util.Date;
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
 * KhachHang class with table.
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
@Table(name = "KhachHang")
public class KhachHang
        // extends AbstractModel
        implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The khach hang no. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "khachHangNo")
    private Long khachHangNo;

    /** The ma khach hang. */
    @Column(name = "maKhachHang")
    private String maKhachHang;

    /** The ten KH. */
    @Column(name = "tenKH")
    private String tenKH;

    /** The so dien thoai. */
    @Column(name = "soDienThoai")
    private String soDienThoai;

    /** The email. */
    @Column(name = "email")
    private String email;

    /** The ngay dang ky. */
    @Column(name = "ngayDangKy")
    private Date ngayDangKy;

    /** The trang thai KH. */
    @Column(name = "trangThaiKH")
    private Boolean trangThaiKH;

    /** The trang thai xoa. */
    @Column(name = "trangThaiXoa")
    private Boolean trangThaiXoa;

    /** The nguoi tao. */
    @Column(name = "nguoiTao")
    private String nguoiTao;

    /** The ghi chu. */
    @Column(name = "ghiChu")
    private String ghiChu;

    /** The dia chi list. */
    @OneToMany(mappedBy = "khachHang")
    private List<DiaChi> diaChiList;

    /** The hoa don list. */
    @OneToMany(mappedBy = "khachHang")
    private List<HoaDon> hoaDonList;
}
