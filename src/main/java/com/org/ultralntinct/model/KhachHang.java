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
@Builder
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "KhachHang")
public class KhachHang
        // extends AbstractModel
        implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "khachHangNo")
    private Long khachHangNo;

    @Column(name = "maKhachHang")
    private String maKhachHang;

    @Column(name = "tenKH")
    private String tenKH;

    @Column(name = "soDienThoai")
    private String soDienThoai;

    @Column(name = "email")
    private String email;

    @Column(name = "ngayDangKy")
    private Date ngayDangKy;

    @Column(name = "trangThaiKH")
    private Boolean trangThaiKH;

    @Column(name = "trangThaiXoa")
    private Boolean trangThaiXoa;

    @Column(name = "nguoiTao")
    private String nguoiTao;

    @Column(name = "ghiChu")
    private String ghiChu;

    @OneToMany(mappedBy = "khachHang")
    private List<DiaChi> diaChiList;

    @OneToMany(mappedBy = "khachHang")
    private List<HoaDon> hoaDonList;
}
