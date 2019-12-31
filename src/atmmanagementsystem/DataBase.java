
package atmmanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




public class DataBase {
    Connection makeConnection(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:src\\atmmanagementsystem\\atmdata.db");
        } catch (SQLException ex) {
            System.out.println("Failed to Connect");
            
        }
        return conn;
    }
    void updateDatabase(String query){
        Connection conn = makeConnection();
        try {
            Statement stmt = conn.createStatement();
            stmt.execute(query);
        } catch (SQLException ex) {
            System.out.println("Failed to Update");
            System.out.println(ex);
            
        }
    }
    void saveToDataBase(Users user){
        String insertQuery = String.format("INSERT INTO users(username,password) VALUES ('%s','%s')",user.name,user.password);
        updateDatabase(insertQuery);
    }
    void createTable(Users user){
        String insertQuery = String.format("CREATE TABLE IF NOT EXISTS '%s' (name string,nid int,phone int,address string,password string,amount int,age int);",user.name);
        updateDatabase(insertQuery);
    }
    void writeDataBase(Users user){
        String insertQuery = String.format("INSERT INTO '%s'(name,nid,phone,address,password,age) VALUES ('%s','%d','%d','%s','%s','%d')",user.name,user.name,user.nid,user.phoneNumber,user.address,user.password,user.age);
        updateDatabase(insertQuery);
    }
    ResultSet getQuary(String quary){
        Connection conn = makeConnection();
        ResultSet rs = null;
        try {
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(quary);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return rs;
    }
    public boolean checkUsernamePassword(String username,String password){
        String str = String.format("SELECT password FROM users WHERE username = '%s'",username);
        ResultSet rs = getQuary(str);
        boolean bool = false;
        try {
            bool=rs.getString("password").equals(password);
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
            System.out.println("Error");
        }
        return bool;
    }
    public int getAmount(String username){
        Connection conn = makeConnection();
        String str = String.format("SELECT amount FROM '%s'",username);
        ResultSet rs = getQuary(str);
        int amount = 0;
        try {
            amount  = rs.getInt("amount");
            rs.close();
            conn.close();
            
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return amount;
    }
    public void setAmount(String username,int amount){
        String str = String.format("UPDATE '%s' SET amount = '%d' WHERE name = '%s'",username,amount,username);
        updateDatabase(str);
    }
}
