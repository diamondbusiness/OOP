package Lab2;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<GiangVien> danhSachGiangVien = new ArrayList<>();

        System.out.println("Nhap so luong giang vien: ");
        int soGiangVien = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i < soGiangVien; i++) {
            System.out.println("Nhập thông tin giảng viên thứ " + (i + 1));
            System.out.print("Tên: ");
            String ten = sc.nextLine();
            System.out.print("Năm sinh: ");
            int namSinh = sc.nextInt();
            System.out.print("Lương cơ bản: ");
            double luongCoBan = sc.nextDouble();
            System.out.print("Số giờ làm: ");
            double soGio = sc.nextDouble();
            sc.nextLine();

            Khoa khoa = new Khoa("KH01", "Khoa Cong Nghe thong tin");
            GiangVien gv = new GiangVien(ten, namSinh, new Date(), luongCoBan, khoa, soGio);
            danhSachGiangVien.add(gv);
        }

        System.out.println("\nDanh sach giang vien thuoc khoa Cong Nghe Thon tin:");
        for (GiangVien gv : danhSachGiangVien) {
            System.out.println("Ten: " + gv.getTen() + ",Luong: " + gv.tinhLuong());
        }
    }



}
