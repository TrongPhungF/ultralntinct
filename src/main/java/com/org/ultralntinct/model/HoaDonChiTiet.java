package com.org.ultralntinct.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class HoaDonChiTiet {

    private Long HDCTNo;

    private String maHDCT;

    private float giaBan;

    private int soLuong;

    private String ghiChu;

    private String maHoaDon;

    private String maSanPham;
}
