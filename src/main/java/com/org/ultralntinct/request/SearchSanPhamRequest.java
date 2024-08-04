package com.org.ultralntinct.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * The Class SearchSanPhamRequestBuilder.
 * </p>
 *
 * @author MinhNgoc
 */
@Builder
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper=false)
public class SearchSanPhamRequest extends SearchAPI {

    /** The ma san pham. */
    private String maSanPham;

    /** The ten san pham. */
    private String tenSanPham;

    /** The loai san pham. */
    private String loaiSanPham;

    /** The gia niem yet. */
    private Long giaNiemYet;

    /** The so luong ton. */
    private Long soLuongTon;

    /** The free text. */
    private String freeText;
}
