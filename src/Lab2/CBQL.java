package Lab2;

import java.util.Date;

public class CBQL extends  NhanVien{
    private double phuCapCV;

    public CBQL(Date ngayNhanViec, double luongCoBan, double phuCapCV) {
        super(ngayNhanViec, luongCoBan);
        this.phuCapCV = phuCapCV;
    }

    public CBQL(String ten, int NSinh, Date ngayNhanViec, double luongCoBan, double phuCapCV) {
        super(ten, NSinh, ngayNhanViec, luongCoBan);
        this.phuCapCV = phuCapCV;
    }

    public double getPhuCapCV() {
        return phuCapCV;
    }

    public void setPhuCapCV(double phuCapCV) {
        this.phuCapCV = phuCapCV;
    }

    @Override
    public double tinhLuong() {
        return getLuongCoBan() * phuCapCV;
    }
}
