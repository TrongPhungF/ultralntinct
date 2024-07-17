package com.org.ultralntinct.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class LoaiSanPham {

    private Long loaiSanPhamNo;

    private String maLoaiSanPham;

    private String tenLoai;

    private String moTa;
}
