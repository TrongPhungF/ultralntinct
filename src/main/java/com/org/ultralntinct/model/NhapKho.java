package com.org.ultralntinct.model;


import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * <p>
 * NhapKho class with table.
 * </p>
 *
 * @author MinhNgoc
 */
@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class NhapKho implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long nhapKhoNo;

    private String maNhapKho;

    private String maNhanVien;

    private LocalDateTime ngayNhap;

    private boolean trangThai;
}
