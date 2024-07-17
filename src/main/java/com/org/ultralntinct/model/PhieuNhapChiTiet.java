package com.org.ultralntinct.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class PhieuNhapChiTiet {

    private Long PNCTNo;

    private String maPNCT;

    private float giaNhap;

    private int soLuong;

    private String maSanPham;

    private String maNhaCungCap;

    private String maNhapKho;
}
