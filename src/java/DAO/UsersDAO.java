/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Pojo.Users;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author shani
 */
public class UsersDAO
{
    public static int insert(Users obj) throws ClassNotFoundException, SQLException
    {
        int rowInserted = 0;
        try
        {
         //step-1 load jdbc driver
            Class.forName("com.mysql.jdbc.Driver");
            
         //step-2 define connection url
            String mysqlURL = "jdbc:mysql://localhost:3306/myrkudb?user=root";
            
         //step-3 establish connection
            Connection con = DriverManager.getConnection(mysqlURL);
         
         //step-4 create preparedstatement object
            String sql = "INSERT INTO Users (name,address,age,gender)"
                       +"VALUES (?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1,obj.getUser());
            st.setString(2,obj.getAddress());
            st.setInt(3,obj.getAge());
            st.setString(4,obj.getGender());
            
            rowInserted =st.executeUpdate();
           
          //step-7 close connection
            con.close();
        }
        catch (ClassNotFoundException cnfe)
        {
            System.err.println("Error loading driver:"+cnfe);
        }
        catch (SQLException sqle)
        {
            System.err.println("Error with connection:"+sqle);
        }
        return rowInserted;
    }
    
    public static int update(Users obj) throws ClassNotFoundException, SQLException
    {
        int rowUpdeted = 0; 
        try
        {
         //step-1 load jdbc driver
            Class.forName("com.mysql.jdbc.Driver");
            
         //step-2 define connection url
            String mysqlURL = "jdbc:mysql://localhost:3306/myrkudb?user=root";
            
         //step-3 establish connection
            Connection con = DriverManager.getConnection(mysqlURL);
         
         //step-4 create preparedstatement object
            String sql = "UPDATE Users " + 
		  "SET name=?, address=?, age=?, gender=? " + 
		  "WHERE Id=?";
            PreparedStatement st = con.prepareStatement(sql);
            
            st.setString(1,obj.getUser());
            st.setString(2,obj.getAddress());
            st.setInt(3,obj.getAge());
            st.setString(4,obj.getGender());
            st.setInt(5,obj.getID());
            rowUpdeted =st.executeUpdate();
           
          //step-7 close connection
            con.close();
        }
        catch (ClassNotFoundException cnfe)
        {
            System.err.println("Error loading driver:"+cnfe);
        }
        catch (SQLException sqle)
        {
            System.err.println("Error with connection:"+sqle);
        }
        return rowUpdeted;
    }
    
     public static void delete(int id) throws ClassNotFoundException, SQLException
    {
        try
        {
         //step-1 load jdbc driver
            Class.forName("com.mysql.jdbc.Driver");
            
         //step-2 define connection url
            String mysqlURL = "jdbc:mysql://localhost:3306/myrkudb?user=root";
            
         //step-3 establish connection
            Connection con = DriverManager.getConnection(mysqlURL);
         
         //step-4 create preparedstatement object
            String sql = "DELETE FROM Users " + 
		  "WHERE Id=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1,id);
        
            int rowDeleted =st.executeUpdate();
           
          //step-7 close connection
            con.close();
        }
        catch (ClassNotFoundException cnfe)
        {
            System.err.println("Error loading driver:"+cnfe);
        }
        catch (SQLException sqle)
        {
            System.err.println("Error with connection:"+sqle);
        }
    }
     public static List<Users> getAllUsers() throws ClassNotFoundException, SQLException
    {
         List<Users> list=new ArrayList<Users>();
        try
        {
         //step-1 load jdbc driver
            Class.forName("com.mysql.jdbc.Driver");
            
         //step-2 define connection url
            String mysqlURL = "jdbc:mysql://localhost:3306/myrkudb?user=root";
            
         //step-3 establish connection
            Connection con = DriverManager.getConnection(mysqlURL);
         
         //step-4 create preparedstatement object
            String sql = "SELECT * FROM Users";
            PreparedStatement st = con.prepareStatement(sql);
                       
            ResultSet rs =st.executeQuery();
           
            while(rs.next()){  
                Users e=new Users();  
                e.setID(rs.getInt(1));  
                e.setUser(rs.getString(2));  
                e.setAddress(rs.getString(3));  
                e.setAge(rs.getInt(4));  
                e.setGender(rs.getString(5));  
                list.add(e);  
            }  
          //step-7 close connection
            con.close();
        }
        catch (ClassNotFoundException cnfe)
        {
            System.err.println("Error loading driver:"+cnfe);
        }
        catch (SQLException sqle)
        {
            System.err.println("Error with connection:"+sqle);
        }
        return list;
    }
     public static Users getUserById(int id) throws ClassNotFoundException, SQLException
    {
        Users e=new Users();  
        try
        {
         //step-1 load jdbc driver
            Class.forName("com.mysql.jdbc.Driver");
            
         //step-2 define connection url
            String mysqlURL = "jdbc:mysql://localhost:3306/myrkudb?user=root";
            
         //step-3 establish connection
            Connection con = DriverManager.getConnection(mysqlURL);
         
         //step-4 create preparedstatement object
            String sql = "SELECT * FROM Users WHERE Id = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1,id);  
            
            ResultSet rs=st.executeQuery();  
           while(rs.next()){  
                e.setID(rs.getInt(1));  
                e.setUser(rs.getString(2));  
                e.setAddress(rs.getString(3));  
                e.setAge(rs.getInt(4));  
                e.setGender(rs.getString(5));   
            }  
          //step-7 close connection
            con.close();
        }
        catch (ClassNotFoundException cnfe)
        {
            System.err.println("Error loading driver:"+cnfe);
        }
        catch (SQLException sqle)
        {
            System.err.println("Error with connection:"+sqle);
        }
        return e;
    }
}
