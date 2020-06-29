/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

/**
 *
 * @author vuhoa
 */
import entity.Product;
import java.sql.*;
import java.util.Vector;

public class ProductService {
    String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String url = "jdbc:sqlserver://CASTIELVH\\CASTIEL:1433; databaseName=PE2020; "
                + " user=sa; password=Anhyeuem1";
    public Connection openConnection() throws Exception{
        //load && instantiate SQLserverDriver(Reflection -> reverser engineering)
        Class.forName(driver);
        return DriverManager.getConnection(url);
    }
    public Vector<Product> getAllProdut() throws Exception{
        //try-with-resource (JDK7+)
        Vector<Product> list = new Vector<>();
        String query = "Select * from Products";
        try (Connection c = openConnection();
            Statement st = c.createStatement()){;
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {                
                int ID = rs.getInt("ID");
                String Name = rs.getString("Name");
                float Price = rs.getFloat("Price");
                Product product = new Product(ID, Name, Price);
                list.add(product);
            }
        }
        return list;
    }
    public Product getProductByID(int ID) throws Exception{
        String query = "Select * From Products Where ID = ?";
        try(Connection c = openConnection();
                PreparedStatement ps = c.prepareStatement(query)){
            ps.setInt(1, ID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Product(rs.getInt("ID"), 
                                    rs.getString("Name"), 
                                    rs.getFloat("Price"));
            }
        }
        return null;
    }
    public int insertProduct(Product pro) throws Exception{
        String query = "Insert into Products Values(?, ?, ?)";
        try (Connection c = openConnection();
             PreparedStatement ps = c.prepareStatement(query)){
            ps.setInt(1, pro.getID());
            ps.setString(2, pro.getName());
            ps.setFloat(3, pro.getPrice());
            return ps.executeUpdate();// return numbers of affected rows
        }
    }
    public int removeProduct(String code) throws Exception{
        String query = "Delete From Products Where ID = ?";
        try (Connection c = openConnection();
             PreparedStatement ps = c.prepareStatement(query)){
            ps.setString(1, code);
            return ps.executeUpdate();
        }
    }
}
