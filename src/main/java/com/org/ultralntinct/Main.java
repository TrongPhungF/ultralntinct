package com.org.ultralntinct;

import java.io.File;

import com.org.ultralntinct.dao.impl.SanPhamDAOImpl;
import com.org.ultralntinct.dao.jpa.SanPhamDAO;
import com.org.ultralntinct.service.S3Service;

public class Main {

    // private static final Logger LOGGER =
    // Logger.getLogger(Main.class.getName());
    // static DiaChiJpaDAO diaChiDao = new DiaChiDAOImpl();
    static SanPhamDAO sanPhamService = new SanPhamDAOImpl();
    // static S3Service s3Service
    // static KhachHangJpaDAO khachHangService = new KhachHangDAOImpl();
    // static NhanVienJdbcDAO nhanVienService = new NhanVienDAOImpl();

    public static void main(String[] args) {

        // JpaConfig.getEntityManager();

        // AwsConfig.getS3Client();

        // List<Bucket> buckets = s3Service.listBuckets();

        // AwsConfig awsConfig = new AwsConfig();
        // S3Client s3Client = awsConfig.getS3Client();
        // S3Presigner s3Presigner = awsConfig.getS3Presigner();
        S3Service s3Service = new S3Service();
        // Display the bucket names
        // List<Bucket> buckets = s3Service.listBuckets();
        // System.out.println("Buckets:");
        // for (Bucket bucket : buckets) {
        // System.out.println(bucket.name());
        // }
        File file = new File("C:\\Users\\phung\\Pictures\\z4659433629006_7dad5fa299a59ed1b91e213a867ea08c.jpg");

        // s3Service.uploadObject("duanquanlycuahang",
        // "aws/z4659433629006_7dad5fa299a59ed1b91e213a867ea08c.jpg", file);

        String s3 = "%s/%s/%s/%s".formatted("user", "sanpham", "SP001", file.getName());

        // String s3 =
        s3Service.generatePresignedUrl("aws/z4659433629006_7dad5fa299a59ed1b91e213a867ea08c.jpg", "duanquanlycuahang");
        System.out.println(s3);
        // Tìm tất cả KhachHang
        // List<DiaChi> diaChiList = diaChiDao.findAll();
        // diaChiList.forEach(diaChi -> System.out.println(diaChi.toString()));

        // Tìm tất cả KhachHang
        // List<SanPham> diaChiList = sanPhamService.findAll();
        // List<SanPham> diaChiList = sanPhamService.searchSanPham("Đồng hồ");
        // diaChiList.forEach(diaChi ->
        // System.out.println(diaChi.getMaSanPham()));

        // List<SanPham> sanPhamList =
        // sanPhamService.searchSanPham(SearchSanPhamRequest
        // .builder()
        // .maSanPham("1006016")
        //
        // .build());
        // sanPhamList.forEach(sanPham ->
        // System.out.println(sanPham.toString()));
        //

        // Optional<DiaChi> diachi = diaChiDao.findById(2L);
        // if (diachi.isPresent()) {
        // System.out.println(diachi.get());
        // }
        // diaChiDao.deleteById(1003L);

        // diaChiDao.update(DiaChi.builder()
        // .diaChi("Phu Quoc update")
        // .diaChiMacDinh("HCM update")
        // .maDiaChi("DC00000015")
        // .maKhachHang("KH006").build()
        // , 1007L);

        // Tìm tất cả SanPham
        // List<KhachHang> khachHangs = khachHangService.findAll();
        // khachHangs.forEach(khachHang ->
        // System.out.println(khachHang.toString()));

        //
        // nhanVienService.save(NhanVien.builder()
        // .maNhanVien("NV0010")
        // .tenNhanVien("HCM update")
        // .hoNhanVien("DC00000015")
        // .matKhau("KH006")
        // .soDienThoai("KH006")
        // .email("KH006")
        // .chucVu("KH006")
        // .trangThaiXoa(true)
        // .nguoiTao("NV001")
        // .thoiGianTao(java.sql.Date.valueOf(LocalDateTime.now().toLocalDate()))
        // .build()
        // );

    }

}
