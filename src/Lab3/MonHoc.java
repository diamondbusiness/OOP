package Lab3;

import java.util.Scanner;

public class MonHoc {
    private String maMH;
    private String tenMH;
    private int soTinChi;
    private Khoa khoa;

    public MonHoc(String maMH, String tenMH,int soTinChi, Khoa khoa) {
        this.maMH = maMH;
        this.soTinChi = soTinChi;
        this.khoa = khoa;
        this.tenMH = tenMH;
    }


    public MonHoc() {
    }

    public void nhanMonHoc(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập mã MH ");
        this.maMH = sc.nextLine();
        System.out.println("Nhap tên môn học: ");
        this.tenMH = sc.nextLine();
        System.out.println("Nhập số tin chỉ ");
        this.soTinChi = sc.nextInt();
    }


    public void xuatMonHoc(){
        System.out.println("Mã MH: " + this.getMaMH() +
                "\tTen Mh: " + this.getTenMH() +
                "\tSo TC: " + this.getSoTinChi() +
                "\tTenKhoa: " + khoa.getTenKhoa()
        );
    }

    public String getMaMH() {
        return maMH;
    }

    public void setMaMH(String maMH) {
        this.maMH = maMH;
    }

    public String getTenMH() {
        return tenMH;
    }

    public void setTenMH(String tenMH) {
        this.tenMH = tenMH;
    }

    public int getSoTinChi() {
        return soTinChi;
    }

    public void setSoTinChi(int soTinChi) {
        this.soTinChi = soTinChi;
    }

    public Khoa getKhoa() {
        return khoa;
    }

    public void setKhoa(Khoa khoa) {
        this.khoa = khoa;
    }
}
