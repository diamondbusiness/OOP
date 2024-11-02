package Lab2;

public class Student extends Person {
    private String mssv;

    public Student(String mssv) {
        this.mssv = mssv;
    }

    public Student(String ten, int NSinh, String mssv) {
        super(ten, NSinh);
        this.mssv = mssv;
    }




    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }
}
