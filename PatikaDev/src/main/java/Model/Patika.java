package Model;

import Helper.DbConnector;

import javax.swing.plaf.nimbus.State;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Patika {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int id;
    private String name;

    public Patika(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static ArrayList<Patika> getList() {
        ArrayList<Patika> patikaList = new ArrayList<>();
        Patika obj;

        Statement st = null;
        try {
            st = DbConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM patika");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return patikaList;
    }

    public static boolean add(String name){
        String query  =" INSERT INTO patika (name) VALUES (?)";
        try {
            PreparedStatement statement = DbConnector.getInstance().prepareStatement(query);
            statement.setString(1,name);
            return statement.executeUpdate() != -1;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }

    public static boolean Update(int id, String name){
        String query = "UPDATE patika SET name = ? WHERE id = ?";
        try {
            PreparedStatement statement = DbConnector.getInstance().prepareStatement(query);
            statement.setString(1,name);
            statement.setInt(2, id);
            return statement.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static Patika getFetch(int id){
        Patika obj = null;
        String query = "SELECT * FROM patika WHERE id = ?";
        try {
            PreparedStatement statement = DbConnector.getInstance().prepareStatement(query);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                obj = new Patika(rs.getInt("id"), rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }

    public  static  boolean delete(int id){
        String query = "DELETE FROM patika WHERE id = ?";
        try {
            PreparedStatement statement = DbConnector.getInstance().prepareStatement(query);
            statement.setInt(1,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    return true;
    }
}
