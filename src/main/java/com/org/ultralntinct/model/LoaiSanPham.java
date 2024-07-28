package com.org.ultralntinct.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
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
 * LoaiSanPham class with table.
 * </p>
 *
 * @author MinhNgoc
 */
@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "LoaiSanPham")
public class LoaiSanPham implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loaiSanPhamNo")
    private Long loaiSanPhamNo;

    @Column(name = "maLoaiSanPham", unique = true)
    private String maLoaiSanPham;

    @Column(name = "tenLoai")
    private String tenLoai;

    @Column(name = "moTa")
    private String moTa;

    @OneToMany(mappedBy = "loaiSanPham", cascade = CascadeType.ALL)
    private List<SanPham> sanPhamList;
}
