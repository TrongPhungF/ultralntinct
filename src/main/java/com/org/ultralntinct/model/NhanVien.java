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
public class NhanVien {

    private Long nhanVienNo;

    private String maNhanVien;

    private String tenNhanVien;

    private String hoNhanVien;

    private String matKhau;

    private String soDienThoai;

    private String email;

    private String chucVu;

    private boolean trangThaiXoa;

    private String nguoiTao;

    private Date thoiGianTao;
}
