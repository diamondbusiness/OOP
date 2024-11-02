package Lab1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DButils {
    public static List<Product> listProduct(Connection conn) throws SQLException {
        String sql = "Select * from oop_product";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        List<Product> list = new ArrayList<Product>();
        while(rs.next()){
            String code = rs.getString("code");
            String name = rs.getString("name");
            float price = rs.getFloat("price");
            Product sv = new Product(code, name, price);
            list.add(sv);
        }
        return list;
    }

    public static void insertProduct(Connection conn, Product product) throws SQLException {
        String sql = "Insert into oop_product values(?,?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, product.getCode());
        stmt.setString(2, product.getName());
        stmt.setFloat(3, product.getPrice());
        stmt.executeUpdate();
    }

    public static void deleteProduct(Connection conn, Product product) throws SQLException {
        String sql = "Delete from oop_product where code = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, product.getCode());
        stmt.executeUpdate();
    }

    public static void updateProduct(Connection conn, Product product) throws SQLException {
        Product product1 = findProduct(conn, product.getCode());
        if(product1 != null){
            String sql = "Update oop_product set name = ?, price = ? where code = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, product.getName());
            stmt.setFloat(2, product.getPrice());
            stmt.setString(3, product.getCode());
            stmt.executeUpdate();
        } else {
            insertProduct(conn, product);
        }

    }

    public static Product findProduct(Connection conn, String code) throws SQLException {
        String sql = "Select * from oop_product where code = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, code);
        ResultSet rs = stmt.executeQuery();
        if(rs.next()){
            String code2 = rs.getString("code");
            String name = rs.getString("name");
            float price = rs.getFloat("price");
            Product sv = new Product(code2, name, price);
            return sv;
        }else {
            return null;
        }
    }
}
