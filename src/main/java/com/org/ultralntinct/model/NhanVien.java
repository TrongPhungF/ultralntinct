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

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nhanVienNo")
    private Long nhanVienNo;

    @Column(name = "maNhanVien", unique = true)
    private String maNhanVien;

    @Column(name = "tenNhanVien")
    private String tenNhanVien;

    @Column(name = "hoNhanVien")
    private String hoNhanVien;

    @Column(name = "matKhau")
    private String matKhau;

    @Column(name = "soDienThoai")
    private String soDienThoai;

    @Column(name = "email")
    private String email;

    @Column(name = "chucVu")
    private String chucVu;

    @Column(name = "trangThaiXoa")
    private Boolean trangThaiXoa;

    @Column(name = "thoiGianTao")
    private Date thoiGianTao;

    @Column(name = "nguoiTao")
    private String nguoiTao;

    @ManyToOne
    @JoinColumn(name = "nguoiTao", columnDefinition = "maNhanVien", insertable = false, updatable = false)
    private NhanVien nhanVienTao;

    @OneToMany(mappedBy = "nhanVien")
    private List<HoaDon> hoaDonList;
}
