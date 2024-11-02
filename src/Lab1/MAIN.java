package Lab1;

import java.sql.SQLException;
import java.util.Scanner;

public class MAIN {
    public static void main(String[] args) throws SQLException {
//        //Load list product
//        List<Product> list = DButils.listProduct(DbConnection.getConnection());
//        System.out.println(list.toString());
//
////        //Insert Product
////        Product p = new Product();
////        Product product = p.NhapProduct();
////        DButils.insertProduct(sqlServerConnection.connect(), product);
//
//        //Delete Product
////        DButils.deleteProduct(sqlServerConnection.connect(), list.get(0));
//
//        Product product = new Product(list.get(0).getCode(), "ABCC", 2322);
//        DButils.updateProduct(DbConnection.getConnection(), product);



        ListProduct l = new ListProduct();


//        System.out.println("Nhap thong tin product cmoi can them");
//        l.themProduct();
//        System.out.println("Danh Sach Product");
////        l.inListProdcut()

        System.out.println("Nhap code product ma banj muon sua: ");
        Scanner sc = new Scanner(System.in);
        String code = sc.nextLine();
        l.suaProduct();

        System.out.println("Danh sach product: ");
//        l.inListProduct();
    }
}
