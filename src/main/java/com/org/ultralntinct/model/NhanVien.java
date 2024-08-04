package com.org.ultralntinct.model;

import java.io.Serializable;
import java.util.Date;
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
 * NhanVien class with table.
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
@Table(name = "NhanVien")
public class NhanVien implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The nhan vien no. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nhanVienNo")
    private Long nhanVienNo;

    /** The ma nhan vien. */
    @Column(name = "maNhanVien", unique = true)
    private String maNhanVien;

    /** The ten nhan vien. */
    @Column(name = "tenNhanVien")
    private String tenNhanVien;

    /** The ho nhan vien. */
    @Column(name = "hoNhanVien")
    private String hoNhanVien;

    /** The mat khau. */
    @Column(name = "matKhau")
    private String matKhau;

    /** The so dien thoai. */
    @Column(name = "soDienThoai")
    private String soDienThoai;

    /** The email. */
    @Column(name = "email")
    private String email;

    /** The chuc vu. */
    @Column(name = "chucVu")
    private String chucVu;

    /** The trang thai xoa. */
    @Column(name = "trangThaiXoa")
    private Boolean trangThaiXoa;

    /** The thoi gian tao. */
    @Column(name = "thoiGianTao")
    private Date thoiGianTao;

    /** The nguoi tao. */
    @Column(name = "nguoiTao")
    private String nguoiTao;

    /** The nhan vien tao. */
    @ManyToOne
    @JoinColumn(name = "nguoiTao", referencedColumnName = "maNhanVien", insertable = false, updatable = false)
    private NhanVien nhanVienTao;

    /** The hoa don list. */
    @OneToMany(mappedBy = "nhanVien")
    private List<HoaDon> hoaDonList;
}
