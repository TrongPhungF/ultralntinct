package com.org.ultralntinct;

import java.util.List;

import com.org.ultralntinct.dao.DiaChiDAO;
import com.org.ultralntinct.dao.KhachHangDAO;
import com.org.ultralntinct.dao.NhanVienDAO;
import com.org.ultralntinct.dao.SanPhamDAO;
import com.org.ultralntinct.dao.impl.DiaChiDAOImpl;
import com.org.ultralntinct.dao.impl.KhachHangDAOImpl;
import com.org.ultralntinct.dao.impl.NhanVienDAOImpl;
import com.org.ultralntinct.dao.impl.SanPhamDAOImpl;
import com.org.ultralntinct.model.KhachHang;

public class Main {

//    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    static DiaChiDAO diaChiDao = new DiaChiDAOImpl();
    static SanPhamDAO sanPhamService = new SanPhamDAOImpl();
    static KhachHangDAO khachHangService = new KhachHangDAOImpl();
    static NhanVienDAO nhanVienService = new NhanVienDAOImpl();

    public static void main(String[] args) {

        // Tìm tất cả KhachHang
//        List<DiaChi> diaChiList = diaChiDao.findAll();
//        diaChiList.forEach(diaChi -> System.out.println(diaChi.toString()));
         
//        List<SanPham> sanPhamList = sanPhamService.searchSanPham(SearchSanPhamRequest
//                .builder()
//                .maSanPham("1006016")
//                
//                .build());
//        sanPhamList.forEach(sanPham -> System.out.println(sanPham.toString()));
//        
        
//        Optional<DiaChi> diachi = diaChiDao.findById(2L);
//        if (diachi.isPresent()) {
//            System.out.println(diachi.get());
//        }
//        diaChiDao.deleteById(1003L);
        
        
//        diaChiDao.update(DiaChi.builder()
//            .diaChi("Phu Quoc update")
//            .diaChiMacDinh("HCM update")
//            .maDiaChi("DC00000015")
//            .maKhachHang("KH006").build()
//        , 1007L);
        
//      Tìm tất cả SanPham
      List<KhachHang> khachHangs = khachHangService.findAll();
      khachHangs.forEach(khachHang -> System.out.println(khachHang.toString()));

//
//    nhanVienService.save(NhanVien.builder()
//        .maNhanVien("NV0010")
//        .tenNhanVien("HCM update")
//        .hoNhanVien("DC00000015")
//        .matKhau("KH006")
//        .soDienThoai("KH006")
//        .email("KH006")
//        .chucVu("KH006")
//        .trangThaiXoa(true)
//        .nguoiTao("NV001")
//        .thoiGianTao(java.sql.Date.valueOf(LocalDateTime.now().toLocalDate()))
//        .build()
//        );
      
    }

}
