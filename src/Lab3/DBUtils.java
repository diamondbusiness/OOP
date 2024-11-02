package Lab3;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtils {
    public static Khoa getKhoa(int maKhoa, Connection conn) throws SQLException {
        String sql = "select * from Khoa where maKhoa=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, Integer.valueOf(maKhoa));
        ResultSet rs = ps.executeQuery();
        Khoa khoa = null;
        if (rs.next()) {
            khoa = new Khoa();
            khoa.setMaKhoa(rs.getInt("maKhoa"));
            khoa.setTenKhoa(rs.getString("tenKhoa"));
        }
        return khoa;
    }

    public static List<Khoa> listKhoa(Connection conn) throws SQLException {
        String sql = "select * from Khoa";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Khoa> khoaList = new ArrayList<>();
        while (rs.next()) {
            Khoa khoa = new Khoa();
            khoa.setMaKhoa(rs.getInt("maKhoa"));
            khoa.setTenKhoa(rs.getString("tenKhoa"));
            khoaList.add(khoa);
        }
        return khoaList;
    }

    public static List<MonHoc> listMonHoc(Connection conn) throws SQLException {
        String sql = "select * from MonHoc";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        List<MonHoc> monHocs = new ArrayList<MonHoc>();
        while (rs.next()) {
            String maMH = rs.getString("maMH");
            String tenMH = rs.getString("tenMH");
            int soTinChi = rs.getInt("soTinChi");
            int maKhoa = rs.getInt("maKhoa");
            Khoa khoa = getKhoa(maKhoa, conn);
            MonHoc monHoc = new MonHoc(maMH, tenMH, soTinChi, khoa);
            monHocs.add(monHoc);
        }
        return monHocs;
    }


    public static List<MonHoc> layDanhSachMonHocThuocKhoa(Connection conn, Khoa khoa) throws SQLException {
        String sql = "SELECT * FROM MonHoc WHERE maKhoa = ? ORDER BY soTinChi ASC";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, khoa.getMaKhoa());
        ResultSet resultSet = preparedStatement.executeQuery();
        List<MonHoc> monHocs = new ArrayList<>();
        while (resultSet.next()) {
            String maMH = resultSet.getString("maMH");
            String tenMH = resultSet.getString("tenMH");
            int soTinChi = resultSet.getInt("soTinChi");
            MonHoc monHoc  = new MonHoc(maMH, tenMH, soTinChi, khoa);
            monHocs.add(monHoc);
        }
        return monHocs;

    }


    public static void insertMonHoc(Connection connection, MonHoc monHoc) throws SQLException {
        String sql = "INSERT INTO MonHoc VALUES(?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, monHoc.getMaMH());
        preparedStatement.setString(2, monHoc.getTenMH());
        preparedStatement.setInt(3, monHoc.getSoTinChi());
        preparedStatement.setInt(4, monHoc.getKhoa().getMaKhoa());
        preparedStatement.execute();
    }

    public static void updateMonHoc(Connection connection, MonHoc monHoc) throws SQLException {
        MonHoc monHoc1 = findMonHoc(connection, monHoc.getMaMH());
        if(monHoc1 != null) {
            String sql = "UPDATE MonHoc SET tenMH = ?, soTinChi = ?, maKhoa = ? WHERE maKhoa = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, monHoc.getTenMH());
            preparedStatement.setInt(2, monHoc.getSoTinChi());
            preparedStatement.setInt(3, monHoc.getKhoa().getMaKhoa());
            preparedStatement.setInt(4, monHoc.getKhoa().getMaKhoa());
            preparedStatement.execute();
        } else {
            insertMonHoc(connection, monHoc);
        }

    }

    public static MonHoc findMonHoc(Connection connection, String maMonHoc) throws SQLException {
        String sql = "select * from MonHoc where maMH=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, maMonHoc);
        ResultSet rs = preparedStatement.executeQuery();
        MonHoc monHoc = null;
        if (rs.next()) {
           monHoc = new MonHoc();
           monHoc.setMaMH(rs.getString("maMH"));
           monHoc.setTenMH(rs.getString("tenMH"));
           monHoc.setSoTinChi(rs.getInt("soTinChi"));
           monHoc.setKhoa(new Khoa());
        }
        return monHoc;
    }

    public static void deleteMonHoc(Connection connection, MonHoc monHoc) throws SQLException {
        String sql = "DELETE FROM MonHoc WHERE maKhoa=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, monHoc.getKhoa().getMaKhoa());
        preparedStatement.execute();
    }
}
