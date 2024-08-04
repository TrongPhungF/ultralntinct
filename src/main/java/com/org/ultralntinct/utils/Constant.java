package com.org.ultralntinct.utils;

/**
 * <p>
 * Constant class.
 * </p>
 *
 * @author MinhNgoc
 */
public class Constant {

	/** INSERT_INTO. */
	public static final String INSERT_INTO = "INSERT INTO ";

	/** UPDATE. */
	public static final String UPDATE = "UPDATE ";

	/** ID with DiaChi. */
	public static final String DIA_CHI_NO = "diaChiNo";

	/** TABLE_NAME DiaChi. */
	public static final String DIA_CHI_TABLE_NAME = "DiaChi";

	/** ID with SanPham. */
	public static final String SAN_PHAM_NO = "SanPhamNo";

	/** TABLE_NAME SanPham. */
	public static final String SAN_PHAM_TABLE_NAME = "SanPham";

	/** ID with KhachHang. */
	public static final String KHACH_HANG_NO = "KhachHangNo";

	/** TABLE_NAME KhachHang. */
	public static final String KHACH_HANG_TABLE_NAME = "KhachHang";

	/** ID with NhanVien. */
	public static final String NHAN_VIEN_NO = "NhanVienNo";

	/** TABLE_NAME NhanVien. */
	public static final String NHAN_VIEN_TABLE_NAME = "NhanVien";

	/** ID with HoaDon. */
	public static final String HOA_DON_NO = "hoaDonNo";

	/** TABLE_NAME HoaDon. */
	public static final String HOA_DON_TABLE_NAME = "HoaDon";

	/** The Constant BUCKET_NAME_S3. */
	public static final String BUCKET_NAME_S3 = "duanquanlycuahang";

	/** The Constant S3_FORDER. */
	public static final String S3_FOLDER = "%s/%s/%s";
	public static final String ADMIN = "ADMIN";
	public static final String NV_BAN_HANG = "NV_BAN_HANG";
	public static final String NV_KHO = "NV_KHO";
	public static final String USER_SESSION = "user";
	public static final String MESSAGE = "message";

	/**
	 * Instantiates a new constant.
	 */
	private Constant() {
		throw new IllegalStateException("Utility class");
	}

}
