package Lab2;

import java.util.Date;

public class NhanVien extends  Person{
    private Date ngayNhanViec;
    private double luongCoBan;

    public NhanVien(Date ngayNhanViec, double luongCoBan) {
        this.ngayNhanViec = ngayNhanViec;
        this.luongCoBan = luongCoBan;
    }

    public NhanVien(String ten, int NSinh, Date ngayNhanViec, double luongCoBan) {
        super(ten, NSinh);
        this.ngayNhanViec = ngayNhanViec;
        this.luongCoBan = luongCoBan;
    }


    public Date getNgayNhanViec() {
        return ngayNhanViec;
    }

    public void setNgayNhanViec(Date ngayNhanViec) {
        this.ngayNhanViec = ngayNhanViec;
    }

    public double getLuongCoBan() {
        return luongCoBan;
    }

    public void setLuongCoBan(double luongCoBan) {
        this.luongCoBan = luongCoBan;
    }

    public double tinhLuong(){
        return luongCoBan;
    }
}
