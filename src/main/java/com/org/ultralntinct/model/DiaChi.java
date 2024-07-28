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

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "diaChiNo")
    private Long diaChiNo;

    @Column(name = "maDiaChi")
    private String maDiaChi;

    @Column(name = "diaChi")
    private String diaChi;

    @Column(name = "diaChiMacDinh")
    private String diaChiMacDinh;

    @Column(name = "trangThaiXoa")
    private Boolean trangThaiXoa;

    @ManyToOne
    @JoinColumn(name = "maKhachHang", referencedColumnName = "maKhachHang")
    private KhachHang khachHang;
}
