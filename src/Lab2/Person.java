package Lab2;

public class Person {
    private String ten;
    private int NSinh;

    public Person() {
    }

    public Person(String ten, int NSinh) {
        this.ten = ten;
        this.NSinh = NSinh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getNSinh() {
        return NSinh;
    }

    public void setNSinh(int NSinh) {
        this.NSinh = NSinh;
    }
}
