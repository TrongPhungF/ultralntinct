package com.org.ultralntinct.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class HoaDon {

    private Long hoaDonNo;

    private String maHoaDon;

    private String maKhachHang;

    private String maNhanVien;

    private Date ngayLap;

    private boolean trangThai;
}
