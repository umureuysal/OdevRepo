package Model;

import Helper.DbConnector;
import Helper.Helper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class User {
    private int id;
    private String name;
    private String username;
    private String password;
    private String type;

    public User(){}

    public User(int id, String name, String username, String password, String type) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.type = type;
    }

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static ArrayList<User> getList(){
        ArrayList<User> userList = new ArrayList<>();
        String query = "Select * from users";
        User user;
        try {
            Statement statement = DbConnector.getInstance().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setUsername(resultSet.getString("userName"));
                user.setPassword(resultSet.getString("password"));
                user.setType(resultSet.getString("type"));
                userList.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }

    public static boolean add(String name, String username, String password, String type) {
        String query = "INSERT INTO user (name, userName, password, type) VALUES (?, ?, ?, ?)";
        User findUser = User.getFetch(username);
        if(findUser != null){
            Helper.showMsg("Lütfen farklı bir kullanıcı adı giriniz.");
            return false;
        }
        try {
            PreparedStatement statement = DbConnector.getInstance().prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2, username);
            statement.setString(3, password);
            statement.setString(4, type);
            statement.close();
            if(statement.executeUpdate() == -1){
                Helper.showMsg("error");
            }
            return statement.executeUpdate() != -1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    return true;
    }

    public static boolean update(int id, String name, String username, String pass, String type){
        String query = "UPDATE user SET name = ?, userName=?, password=?, type=? WHERE id=?";
        User findUser = User.getFetch(username);
        if(findUser != null && findUser.getId() != id){
            Helper.showMsg("Lütfen farklı bir kullanıcı adı giriniz.");
            return false;
        }
        try {
            PreparedStatement statement = DbConnector.getInstance().prepareStatement(query);
            statement.setString(1,name);
            statement.setString(2,username);
            statement.setString(3,pass);
            statement.setString(4,type);
            statement.setInt(5,id);
            return statement.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static User getFetch(String username){
        User user = null;
        String query = "SELECT * FROM user WHERE userName = ?";
        try {
            PreparedStatement statement = DbConnector.getInstance().prepareStatement(query);
            statement.setString(1,username);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setUsername(resultSet.getString("userName"));
                user.setPassword(resultSet.getString("password"));
                user.setType(resultSet.getString("type"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    public static User getFetch(int id){
        User user = null;
        String query = "SELECT * FROM user WHERE userName = ?";
        try {
            PreparedStatement statement = DbConnector.getInstance().prepareStatement(query);
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setUsername(resultSet.getString("userName"));
                user.setPassword(resultSet.getString("password"));
                user.setType(resultSet.getString("type"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public static boolean delete(int id){
        String query = "DELETE FROM user WHERE id = ?";
        try {
            PreparedStatement preparedStatement = DbConnector.getInstance().prepareStatement(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static ArrayList<User> searchUserList(String query){
        ArrayList<User> userList = new ArrayList<>();
        User user;
        try {
            Statement statement = DbConnector.getInstance().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setUsername(resultSet.getString("userName"));
                user.setPassword(resultSet.getString("password"));
                user.setType(resultSet.getString("type"));
                userList.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }

    public static  String searchquery(String name, String username, String type){
        String query = "SELECT * FROM user WHERE userName LIKE '%{{userName}}%' AND name LIKE '%{{name}} AND type LIKE '%{{type}}%'";
        query = query.replace("{{userName}}",username);
        query = query.replace("{{name}}",name);
        query = query.replace("{{type}}",type);
        return query;
    }
}
