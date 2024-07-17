package com.org.ultralntinct.model;

import lombok.Builder;
import lombok.Data;
//import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

/**
 * <p>
 * DiaChi class with table.
 * </p>
 *
 * @author MinhNgoc
 */
//@EqualsAndHashCode(callSuper = true)
@Builder
@Data
@RequiredArgsConstructor
public class DiaChi
//    extends AbstractModel {
{
    private Long diaChiNo;

    private String maDiaChi;

    private String diaChi;

    private String diaChiMacDinh;

    private boolean trangThaiXoa;

    private String maKhachHang;
}
