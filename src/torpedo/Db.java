/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package torpedo;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author latyak
 */

public class Db {

    private static Connection connect;
    private static Statement st;
    private static ResultSet rs;

    public static void getData(String query) {
        try {
            rs = st.executeQuery(query);
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                System.out.println(name + " " + email);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static ArrayList getProfile(String userName){
        ArrayList result=new ArrayList();
        try {
            rs = st.executeQuery("SELECT * FROM users where username='"+userName+"'");
            while (rs.next()) {
                String country = rs.getString("country");
                String pwd = rs.getString("pwd");
                result.add(country);
                result.add(pwd);
            }
        } catch (Exception e) {
            System.out.println("Hiba a lekérdezés során:" +e);
        }
        
        return result;
    }

    public static void registration(String userName, String nickName, String pwd, String country) throws SQLException {

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();

        st.executeUpdate("INSERT INTO users (username, nickname, pwd, country, date) "
                + "VALUES ('" + userName + "','" + nickName + "','" + pwd + "','" + country + "','" + dateFormat.format(date) + "')");
    }

    public static boolean loginValidate(String userName, String pwd) throws SQLException {

        rs = st.executeQuery("SELECT count(*) FROM users where username='" + userName + "' and pwd='" + pwd + "'");

        String rows = "";
        while (rs.next()) {
            rows = rs.getString("count(*)");
        }

        if (rows.equals("1")) {
            return true;
        } else {
            return false;
        }
    }
    
    
    public static boolean existsUser(String user) throws SQLException{
        rs = st.executeQuery("SELECT username FROM users where username='"+user+"'");
        
        String rows = "";
        while (rs.next()) {
            rows = rs.getString("username");
        }

        if (rows.equals("1")) {
            return false;
        } else {
            return true;
        }
    }

    public static void openCon() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/torpedo", "root", "");
            st = connect.createStatement();
        } catch (ClassNotFoundException e) {
            System.out.println("Hiba! Hiányzik a JDBC driver.");
        } catch (SQLException e) {
            System.out.println("Hiba! Nem sikerült megnyitni a kapcsolatot az adatbázis-szerverrel.");
        }
    }

    public static void closeCon() {
        try {
            connect.close();
        } catch (SQLException e) {
            System.out.println("Hiba! Nem sikerült lezárni a kapcsolatot az adatbázis-szerverrel.");
        }
    }
}
