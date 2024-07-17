package com.org.ultralntinct.model;


import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class NhapKho {

    private Long nhapKhoNo;

    private String maNhapKho;

    private String maNhanVien;

    private LocalDateTime ngayNhap;

    private boolean trangThai;
}
