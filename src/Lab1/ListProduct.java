package Lab1;

import java.sql.Connection;
import java.sql.SQLException;

public class ListProduct {


    public void themProduct() throws SQLException {
        Product p = new Product();
        p.NhapProduct();
        Connection conn = DbConnection.getConnection();
        DButils.insertProduct(conn, p);
    }

    public void suaProduct() throws SQLException {
        Product p = new Product();
        p.NhapProduct();
        Connection conn = DbConnection.getConnection();
        DButils.updateProduct(conn, p);
    }

    public void xoaProduct() throws SQLException {

    }
}
