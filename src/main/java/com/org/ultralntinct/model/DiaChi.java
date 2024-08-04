package com.org.ultralntinct.model;

import java.io.Serializable;

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
 * DiaChi class with table.
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
@Table(name = "DiaChi")
public class DiaChi
        // extends AbstractModel
        implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The dia chi no. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "diaChiNo")
    private Long diaChiNo;

    /** The ma dia chi. */
    @Column(name = "maDiaChi")
    private String maDiaChi;

    /** The dia chi. */
    @Column(name = "diaChi")
    private String diaChi;

    /** The dia chi mac dinh. */
    @Column(name = "diaChiMacDinh")
    private String diaChiMacDinh;

    /** The trang thai xoa. */
    @Column(name = "trangThaiXoa")
    private Boolean trangThaiXoa;

    /** The khach hang. */
    @ManyToOne
    @JoinColumn(name = "maKhachHang", referencedColumnName = "maKhachHang")
    private KhachHang khachHang;
}
