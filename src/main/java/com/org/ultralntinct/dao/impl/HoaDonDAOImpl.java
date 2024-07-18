package com.org.ultralntinct.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.org.ultralntinct.dao.AbstractCrudDao;
import com.org.ultralntinct.model.HoaDon;
import com.org.ultralntinct.model.HoaDonChiTiet;
import com.org.ultralntinct.dao.HoaDonDAO;
import com.org.ultralntinct.utils.Constant;

/**
 * <p>
 * HoaDonDAOImpl represents a concrete implementation of HoaDonDAO.
 * </p>
 *
 * @author MinhNgoc.
 */
public class HoaDonDAOImpl extends AbstractCrudDao<HoaDon, Long> implements HoaDonDAO {

    /**
     * <p>
     * Method mapRow HoaDon.
     * </p>
     *
     * @param rs ResultSet.
     * @return HoaDon.
     * @throws SQLException SQLException.
     * @author MinhNgoc.
     */
    @Override
    protected HoaDon mapRow(ResultSet rs) throws SQLException {
        return HoaDon.builder().hoaDonNo(rs.getLong(Constant.SAN_PHAM_NO)).maHoaDon(rs.getString("maHoaDon"))
                .maKhachHang(rs.getString("maKhachHang")).maNhanVien(rs.getString("maNhanVien"))
                .ngayLap(rs.getDate("ngayLap")).trangThai(rs.getBoolean("trangThai")).build();
    }

    /**
     * <p>
     * Method getTableName table HoaDon.
     * </p>
     *
     * @return String.
     * @author MinhNgoc.
     */
    @Override
    protected String getTableName() {
        return Constant.HOA_DON_TABLE_NAME;
    }

    /**
     * <p>
     * Method getPrimaryKeyColumnName
     * </p>
     *
     * @return String.
     * @author MinhNgoc
     */
    @Override
    protected String getPrimaryKeyColumnName() {
        return Constant.HOA_DON_NO;
    }

    /**
     * <p>
     * Method getEntityValues.
     * </p>
     * 
     * @param entity HoaDon.
     * @return Object[].
     * @author MinhNgoc.
     */
    @Override
    protected Object[] getEntityValues(HoaDon entity) {
        return new Object[] { entity.getMaHoaDon(), entity.getMaKhachHang(), entity.getMaNhanVien(),
                entity.getNgayLap(), entity.isTrangThai() };
    }

    /**
     * <p>
     * Method getInsertQuery.
     * </p>
     * 
     * @return String
     * @author MinhNgoc.
     */
    @Override
    protected String getInsertQuery() {
        return """
                INSERT INTO
                """ + Constant.SAN_PHAM_TABLE_NAME + """
                (maHoaDon, maKhachHang, maNhanVien, ngayLap, trangThai)
                values (?,?,?,?,?);
                """;
    }

    /**
     * <p>
     * Method getUpdateQuery.
     * </p>
     * 
     * @return String
     * @author MinhNgoc.
     */
    @Override
    protected String getUpdateQuery() {
        return """
                UPDATE
                """ + Constant.SAN_PHAM_TABLE_NAME + """
                SET maHoaDon = ?, maKhachHang = ?, maNhanVien = ?, ngayLap = ?, trangThai = ? WHERE """
                + Constant.SAN_PHAM_NO + " = ?";
    }

    /**
     * <p>
     * Method get max maxMaSanPham.
     * </p>
     *
     * @return long maxMaSanPham.
     * @author MinhNgoc.
     */
    @Override
    public long getMaxMaSanPham() throws SQLException {
        String sql = " SELECT COUNT(1) MAX_MA_HOADON FROM " + getTableName();

        PreparedStatement stmt = AbstractCrudDao.connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getLong("MAX_MA_HOADON");
        }
        return 0L;
    }

    @Override
    public void save(HoaDon hoaDon, List<HoaDonChiTiet> hoaDonChiTietList) throws SQLException {
        String insertHoaDonChiTietSql = """
        INSERT INTO HoaDonChiTiet(maHDCT, maHoaDon, maSanPham, giaBan, soLuong, ghiChu)
        VALUES (?, ?, ?, ?, ?, ?);
        """;

        try (PreparedStatement hoaDonStmt = connection.prepareStatement(getInsertQuery());
                PreparedStatement chiTietStmt = connection.prepareStatement(insertHoaDonChiTietSql)) {

            // Insert into HoaDon table
            hoaDonStmt.setString(1, hoaDon.getMaHoaDon());
            hoaDonStmt.setDate(2, new java.sql.Date(hoaDon.getNgayLap().getTime()));
            hoaDonStmt.setString(3, hoaDon.getMaKhachHang());
            hoaDonStmt.executeUpdate();

            // Insert into HoaDonChiTiet table
            for (HoaDonChiTiet chiTiet : hoaDonChiTietList) {
                chiTietStmt.setString(1, chiTiet.getMaHDCT());
                chiTietStmt.setString(2, chiTiet.getMaHoaDon());
                chiTietStmt.setString(3, chiTiet.getMaSanPham());
                chiTietStmt.setDouble(4, chiTiet.getGiaBan());
                chiTietStmt.setFloat(5, chiTiet.getGiaBan());
                chiTietStmt.setInt(6, chiTiet.getSoLuong());
                chiTietStmt.setInt(7, chiTiet.getSoLuong());
                chiTietStmt.addBatch();
            }
            chiTietStmt.executeBatch();
        } catch (SQLException e) {
            throw new SQLException("Failed to create invoice and details", e);
        }
    }
}
