package com.example.vikum;

import java.util.*;
import java.sql.*;
public class UsersDao {

    //  database
    private static String jdbcURL = "jdbc:mysql://localhost:3306/student";
    private static String jdbcUsername = "root";

    // provide your appropriate password here
    private static String jdbcPassword = "Vikum@199684";

    public static Connection getConnection(){
        Connection con=null;
        try {
            // This is the way of connecting MySQL
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            System.out.println("Message.. " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Message.. " + e.getMessage());
            e.printStackTrace();
        }
        return con;
    }

    public static int save(Users e) {

        int status = 0;
        try {
            Connection con = UsersDao.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "insert into studentTable(name ,im,dob,path,company) values (?,?,?,?,?)");
            ps.setString(1, e.getName());
            ps.setInt(2, e.getIm());
            ps.setString(3, e.getDob());
            ps.setString(4, e.getPath());
            ps.setString(5, e.getCompany());

            status = ps.executeUpdate();

            con.close();
        }
        catch (Exception ex) {
            System.out.println("Message.." + ex.getMessage());
            ex.printStackTrace();
        }

        return status;

    }

    public static List<Users> getAllGeekUses() {

        List<Users> list = new ArrayList<Users>();

        try {
            Connection con = UsersDao.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "select * from studentTable");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Users e = new Users();
                e.setId(rs.getInt(1));
                e.setName(rs.getString(2));
                e.setIm(rs.getInt(3));
                e.setDob(rs.getString(4));
                e.setPath(rs.getString(5));
                e.setCompany(rs.getString(6));
                list.add(e);
            }
            con.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public static int update(Users e) {
        int status = 0;
        try {
            Connection con = UsersDao.getConnection();

            PreparedStatement ps = con.prepareStatement(
                    "update studentTable set name=?,im=?,dob=?,path=?,company=? where id=?");
            ps.setString(1, e.getName());
            ps.setInt(2, e.getIm());
            ps.setString(3, e.getDob());
            ps.setString(4, e.getPath());
            ps.setString(5, e.getCompany());
            ps.setInt(6, e.getId());

            status = ps.executeUpdate();

            con.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }

    public static int delete(int id) {
        int status = 0;
        try {
            Connection con = UsersDao.getConnection();
            // delete query is given to delete the record for
            // the given geekUserId
            PreparedStatement ps = con.prepareStatement(
                    "delete from studentTable where id=?");
            ps.setInt(1, id);
            status = ps.executeUpdate();
            con.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    public static Users getUsersById(int id) {

        Users e = new Users();

        try {
            Connection con = UsersDao.getConnection();
            // We are getting the details for a specific user
            // and hence the query has to be sent in the below
            // way
            PreparedStatement ps = con.prepareStatement(
                    "select * from studentTable where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                e.setId(rs.getInt(1));
                e.setName(rs.getString(2));
                e.setIm(rs.getInt(3));
                e.setDob(rs.getString(4));
                e.setPath(rs.getString(5));
                e.setCompany(rs.getString(6));
            }
            con.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        return e;
    }


    // Rest of the methods like Save,
    // Update, Delete etc., should come here
}
