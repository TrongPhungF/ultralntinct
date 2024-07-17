package com.org.ultralntinct.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class NhaCungCap {

    private Long nhaCungCapNo;

    private String maNhaCungCap;

    private String tenNCC;

    private String soDienThoai;

    private String email;

}
