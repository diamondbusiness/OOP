package Lab3;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

public class ListKhoa {
    private List<Khoa> listKhoas;

    public List<Khoa> getList() {
        return listKhoas;
    }

    public void setList(List<Khoa> listKhoas) {
        this.listKhoas = listKhoas;
    }

    public void layDanhSachKhoa() throws SQLException {
        Connection conn = DbConnection.getConnection();
        listKhoas = DBUtils.listKhoa(conn);

        System.out.printf("%-5s %-15s %-25s\n", "STT", "Mã Khoa", "Tên Khoa");
        System.out.println("---------------------------------");

        int index = 1;
        for (Khoa khoa : listKhoas) {
            System.out.printf("%-5d %-15s %-25s\n",
                    index++,
                    khoa.getMaKhoa(),
                    khoa.getTenKhoa());
        }
    }
}
