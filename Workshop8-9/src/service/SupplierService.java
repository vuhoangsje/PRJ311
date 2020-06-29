
package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Vector;
import entity.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class SupplierService {

    String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String url = "jdbc:sqlserver://CASTIELVH\\CASTIEL:1433; databaseName=ItemDB; "
            + " user=sa; password=Anhyeuem1";

    public Connection openConnection() throws Exception {
        Class.forName(driver);
        return DriverManager.getConnection(url);
    }

    public Vector<Supplier> getAllSupplier() throws Exception {
        Vector<Supplier> list = new Vector<>();
        String query = "Select * from Suppliers";
        try (Connection c = openConnection()) {
            PreparedStatement ps = c.prepareStatement(query);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                list.add(new Supplier(result.getString("SupCode"), result.getString("SupName"), result.getString("Address"), result.getBoolean("colloborating")));
            }
        }
        return list;
    }

    public Supplier getSupplierByCode(String code) throws Exception {
        String query = "select * from Suppliers where SupCode = ?";
        try (Connection c = openConnection()) {
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, code);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Supplier(rs.getString("SupCode"), rs.getString("SupName"), rs.getString("Address"), rs.getBoolean("colloborating"));
            }
        }
        return null;
    }

    public int insertSupplier(Supplier sup) throws Exception {
        String query = "insert into Suppliers Values(?,?,?,?)";
        try (Connection c = openConnection()) {
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, sup.getCode());
            ps.setString(2, sup.getName());
            ps.setString(3, sup.getAddress());
            ps.setBoolean(4, sup.isColloboration());
            return ps.executeUpdate(); // return number of affected rows
        }
    }

    public int updateSupplier(Supplier sup) throws Exception {
        String query = "update Suppliers Set SupName = ?, Address = ?, colloborating =? where SupCode = ?";
        try (Connection c = openConnection()) {
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, sup.getName());
            ps.setString(2, sup.getAddress());
            ps.setBoolean(3, sup.isColloboration());
            ps.setString(4, sup.getCode());
            return ps.executeUpdate(); // return number of affected rows
        }
    }

    public int removeSupplier(String code) throws Exception {
        String query = "delete from Suppliers where SupCode = ?";
        try (Connection c = openConnection()) {
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, code);
            return ps.executeUpdate(); // return number of affected rows
        }
    }
}
