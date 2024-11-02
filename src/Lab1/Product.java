package Lab1;

import java.util.Scanner;

public class Product {
    private String code;
    private String name;
    private float price;


    public Product() {
    }

    public Product(String code, String name, float price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }


    public Product NhapProduct(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập mã: ");
        this.code = sc.nextLine();
        System.out.println("Nhập tên: ");
        this.name = sc.nextLine();
        System.out.println("Nhập giá: ");
        this.price = sc.nextFloat();
        return new Product(this.code, this.name, this.price);
    }

    public void xuatProduct(){
        System.out.println("Code : " + this.getCode() +
                "\tName: " + this.getName() +
                "\tPrice : " + this.getPrice()
        );
    }



    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
