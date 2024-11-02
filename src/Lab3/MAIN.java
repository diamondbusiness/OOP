package Lab3;

import java.sql.SQLException;
import java.util.Scanner;

public class MAIN {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        ListMonHoc listMonHoc = new ListMonHoc();
        int choice;
        do {

            System.out.println("\n");
            System.out.println("-------------MENU------------------");
            System.out.println("1. Xuất ra danh sách môn học từ database");
            System.out.println("2. Thêm môn học từ database");
            System.out.println("3. Xóa tất các môn học thuộc Khoa từ database");
            System.out.println("4. Cập nhật thông tin môn học");
            System.out.println("5. In danh sách các môn học thuộc Khoa");
            System.out.println("6. Thoát\n");
            System.out.println("Nhập lựa chọn:");
            choice =  sc.nextInt();
            if(choice == 1) {
                listMonHoc.layDanhSachMonHoc();
            } else if(choice == 2) {
                listMonHoc.themMonHoc();
            } else if(choice == 3) {
                listMonHoc.xoaMonHoc();
            } else if(choice == 4) {
                listMonHoc.suaMonHoc();
            } else if(choice == 5) {
                listMonHoc.layDanhSachMonHocThuocKhoa();
            } else if(choice == 6) {
                System.out.println("Thank you for using our program!");
            }else {
                System.out.println("Nhập lựa chọn không hơp lệ. Vui lòng nhập lại!");
            }
        } while (choice != 0);
    }
}
