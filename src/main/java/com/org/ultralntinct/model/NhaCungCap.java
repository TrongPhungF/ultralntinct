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
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * <p>
 * NhaCungCap class with table.
 * </p>
 *
 * @author MinhNgoc
 */
@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "NhaCungCap")
public class NhaCungCap implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nhaCungCapNo")
    private Long nhaCungCapNo;

    @Column(name = "maNhaCungCap", unique = true)
    private String maNhaCungCap;

    @Column(name = "tenNCC")
    private String tenNCC;

    @Column(name = "soDienThoai")
    private String soDienThoai;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "nhaCungCap")
    private List<PhieuNhapChiTiet> phieuNhapChiTietList;
}
