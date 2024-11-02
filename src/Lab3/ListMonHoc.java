package Lab3;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ListMonHoc {
    private List<MonHoc> monHocs;

    public List<MonHoc> getMonHocs() {
        return monHocs;
    }
    public void setMonHocs(List<MonHoc> monHocs) {
        this.monHocs = monHocs;
    }

    MonHoc monHoc = null;

    public void printMonHocList(List<MonHoc> monHocs){
        System.out.printf("%-5s %-15s %-25s %-10s %-20s\n", "STT", "Mã MH", "Tên Môn Học", "Số TC", "Tên Khoa");
        System.out.println("----------------------------------------------------------------------");

        int index = 1;
        for (MonHoc monHoc : monHocs) {
            System.out.printf("%-5d %-15s %-25s %-10d %-20s\n",
                    index++,
                    monHoc.getMaMH(),
                    monHoc.getTenMH(),
                    monHoc.getSoTinChi(),
                    monHoc.getKhoa().getTenKhoa());
        }
    }

    public void layDanhSachMonHoc() throws SQLException {
        Connection conn = DbConnection.getConnection();
         monHocs = DBUtils.listMonHoc(conn);
        printMonHocList(monHocs);

    }

    public void layDanhSachMonHocThuocKhoa() throws SQLException {
        Connection conn = DbConnection.getConnection();
        Khoa khoa = selectedKhoa(4);
        monHocs = DBUtils.layDanhSachMonHocThuocKhoa(conn, khoa);
        System.out.println("Danh danh các môn học thuộc Khoa: ");
        printMonHocList(monHocs);
    }


    public Khoa selectedKhoa(int flag) throws SQLException {
        Scanner sc = new Scanner(System.in);
        ListKhoa listKhoa = new ListKhoa();
        System.out.println("Danh sách các Khoa");
        listKhoa.layDanhSachKhoa();

        if(flag == 1){
            System.out.println("Chọn STT của Khoa để thêm môn học : ");
        } else if(flag == 2){
            System.out.println("Chọn STT của Khoa để sửa môn học: ");
        } else if(flag == 3){
            System.out.println("Chọn STT của Khoa để xóa tất cả môn học: ");
        } else {
            System.out.println("Chọn STT của Khoa để lấy tất cả môn học: ");
        }

        int selectedKhoaIndex;

        do {
            selectedKhoaIndex = sc.nextInt();
            if (selectedKhoaIndex <= 0 || selectedKhoaIndex > listKhoa.getList().size()) {
                System.out.println("Vui lòng chọn lại STT hợp lệ: ");
            }
        } while (selectedKhoaIndex <= 0 || selectedKhoaIndex > listKhoa.getList().size());
        Khoa selectedKhoa = listKhoa.getList().get(selectedKhoaIndex -1);
        return selectedKhoa;
    }


    public void themMonHoc() throws SQLException {
        MonHoc monHoc = new MonHoc();
        monHoc.nhanMonHoc();
        Khoa khoa = selectedKhoa(1);
        monHoc.setKhoa(khoa);
        Connection conn = DbConnection.getConnection();
        DBUtils.insertMonHoc(conn, monHoc);
    }

    public void suaMonHoc() throws SQLException {
        Scanner sc = new Scanner(System.in);
        Connection conn = DbConnection.getConnection();
        monHoc = new MonHoc();
        monHoc.nhanMonHoc();
        Khoa khoa = selectedKhoa(2);
        monHoc.setKhoa(khoa);
        System.out.println(monHoc.getMaMH());
        DBUtils.updateMonHoc(conn, monHoc);
    }

    public void xoaMonHoc() throws SQLException {
        Khoa khoa = selectedKhoa(3);
        monHoc = new MonHoc();
        monHoc.setKhoa(khoa);
        Connection conn = DbConnection.getConnection();
        DBUtils.deleteMonHoc(conn, monHoc);

    }
}
