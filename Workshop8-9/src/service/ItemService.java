
package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Vector;
import entity.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ItemService {

    String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String url = "jdbc:sqlserver://CASTIELVH\\CASTIEL:1433; databaseName=ItemDB; "
            + " user=sa; password=Anhyeuem1";

    public Connection openConnection() throws Exception {
        Class.forName(driver);
        return DriverManager.getConnection(url);
    }

    public Vector<Item> getAllItem() throws Exception {
        String query = "Select * From Items";
        Vector<Item> list = new Vector<>();
        try (Connection c = openConnection()) {
            PreparedStatement ps = c.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Item(rs.getString("itemCode"), rs.getString("itemName"), rs.getString("supCode"),
                        rs.getString("unit"), rs.getInt("price"), rs.getBoolean("supplying")));
            }
        }
        return list;
    }

    public Item getItemByCode(String code) throws Exception {
        String query = "Select * from Items where itemCode = ?";
        Item item = null;
        try (Connection c = openConnection()) {
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, code);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                item = new Item(rs.getString("itemCode"), rs.getString("itemName"), rs.getString("supCode"),
                        rs.getString("unit"), rs.getInt("price"), rs.getBoolean("supplying"));
            }
        }
        return item;
    }

    public Vector<Item> getItemByName(String name) throws Exception {
        String query = "Select * from Items where itemName like ?";
        name = "%" + name + "%";
        Vector<Item> list = new Vector<>();
        try (Connection c = openConnection()) {
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Item(rs.getString("itemCode"), rs.getString("itemName"), rs.getString("supCode"),
                        rs.getString("unit"), rs.getInt("price"), rs.getBoolean("supplying")));
            }
        }
        return list;
    }

    public int getQuantiveBySupCode(String supCode) throws Exception {
        String query = "SELECT count(itemCode) as 'A'from Items where supCode =?;";
        try (Connection c = openConnection()) {
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, supCode);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("A");
            }
        }
        return 0;
    }

    public int insertItem(Item item) throws Exception {
        String query = "Insert into Items values(?,?,?,?,?,?)";
        try (Connection c = openConnection()) {
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, item.getCode());
            ps.setString(2, item.getName());
            ps.setString(3, item.getSupCode());
            ps.setString(4, item.getUnit());
            ps.setInt(5, item.getPrice());
            ps.setBoolean(6, item.isSupplying());
            return ps.executeUpdate(); // return number of affected rows
        }
    }

    public int updateItem(Item item) throws Exception {
        String query = "update Items Set itemName = ?, supCode = ?, "
                + "unit =?,price=?, supplying = ? where itemCode = ?";
        try (Connection c = openConnection()) {
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, item.getName());
            ps.setString(2, item.getSupCode());
            ps.setString(3, item.getUnit());
            ps.setInt(4, item.getPrice());
            ps.setBoolean(5, item.isSupplying());
            ps.setString(6, item.getCode());
            return ps.executeUpdate(); // return number of affected rows
        }
    }

    public int removeItem(String code) throws Exception {
        String query = "delete from Items where itemCode = ?";
        try (Connection c = openConnection()) {
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, code);
            return ps.executeUpdate(); // return number of affected rows
        }
    }

}
