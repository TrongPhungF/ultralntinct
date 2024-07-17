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
public class KhachHang {

    private Long khachHangNo;

    private String maKhachHang;

    private String tenKH;

    private String soDienThoai;

    private String email;

    private Date ngayDangKy;

    private boolean trangThaiKH;

    private boolean trangThaiXoa;

    private String nguoiTao;

    private String ghiChu;
}
