package com.org.ultralntinct.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class SanPham {

    private Long sanPhamNo;

    private String maSanPham;

    private String tenSanPham;

    private float giaNiemYet;

    private int soLuongTon;

    private String hinh;

    private String loaiSanPham;

}
