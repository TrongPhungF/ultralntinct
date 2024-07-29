package com.org.ultralntinct.model;


import java.io.Serializable;
import java.time.LocalDateTime;
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
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * <p>
 * NhapKho class with table.
 * </p>
 *
 * @author MinhNgoc
 */
@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "NhapKho")
public class NhapKho implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nhapKhoNo")
    private Long nhapKhoNo;

    @Column(name = "maNhapKho", unique = true)
    private String maNhapKho;

    @Column(name = "ngayNhap")
    private LocalDateTime ngayNhap;

    @Column(name = "trangThai")
    private boolean trangThai;

    @OneToMany(mappedBy = "nhapKho")
    private List<PhieuNhapChiTiet> phieuNhapChiTietList;
}
