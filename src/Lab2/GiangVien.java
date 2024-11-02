package Lab2;

import java.util.Date;

public class GiangVien extends NhanVien {
        private Khoa khoa;
        private double soGio;

    public GiangVien(Date ngayNhanViec, double luongCoBan, Khoa khoa, double soGio) {
        super(ngayNhanViec, luongCoBan);
        this.khoa = khoa;
        this.soGio = soGio;
    }

    public GiangVien(String ten, int NSinh, Date ngayNhanViec, double luongCoBan, Khoa khoa, double soGio) {
        super(ten, NSinh, ngayNhanViec, luongCoBan);
        this.khoa = khoa;
        this.soGio = soGio;
    }

    @Override
    public double tinhLuong() {
        return getLuongCoBan() * soGio;
    }
}
