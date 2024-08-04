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
 * HoaDon class with table.
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
@Table(name = "HoaDon")
public class HoaDon implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The hoa don no. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hoaDonNo")
    private Long hoaDonNo;

    /** The ma hoa don. */
    @Column(name = "maHoaDon", unique = true)
    private String maHoaDon;

    /** The ngay lap. */
    @Column(name = "ngayLap")
    private Date ngayLap;

    /** The trang thai. */
    @Column(name = "trangThai")
    private Boolean trangThai;

    /** The khach hang. */
    @ManyToOne
    @JoinColumn(name = "maKhachHang", referencedColumnName = "maKhachHang")
    private KhachHang khachHang;

    /** The nhan vien. */
    @ManyToOne
    @JoinColumn(name = "maNhanVien", referencedColumnName = "maNhanVien")
    private NhanVien nhanVien;

    /** The hoa don chi tiet list. */
    @OneToMany(mappedBy = "hoaDon")
    private List<HoaDonChiTiet> hoaDonChiTietList;
}
