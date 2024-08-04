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
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * <p>
 * LoaiSanPham class with table.
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
@Table(name = "LoaiSanPham")
public class LoaiSanPham implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The loai san pham no. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loaiSanPhamNo")
    private Long loaiSanPhamNo;

    /** The ma loai san pham. */
    @Column(name = "maLoaiSanPham", unique = true)
    private String maLoaiSanPham;

    /** The ten loai. */
    @Column(name = "tenLoai")
    private String tenLoai;

    /** The mo ta. */
    @Column(name = "moTa")
    private String moTa;

    /** The san pham list. */
    @OneToMany(mappedBy = "loaiSanPham", cascade = CascadeType.ALL)
    private List<SanPham> sanPhamList;
}
