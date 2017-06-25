package com.msp.spring.jdbc;

import static org.junit.Assert.*;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import static org.junit.Assert.*;

public class PureJdbcTemplateTest {


	public static Connection getConn() {
		
		    String driver = "com.mysql.jdbc.Driver";
		    String url = "jdbc:mysql://localhost:9527/mysql";
		    String username = "root";
		    String password = "MOshanPING";
		    Connection conn = null;
		    try {
		        Class.forName(driver); //classLoader,加载对应驱动
		        conn = (Connection) DriverManager.getConnection(url, username, password);
		    } catch (ClassNotFoundException e) {
		        e.printStackTrace();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    
		    System.out.println(conn);
		  return conn;
	}
	
	
	//@Test 
	public void testInsert() throws SQLException {
		 Connection conn = getConn();
		    int i = 0;
		    String sql = "insert into student (name,id,age) values(?,?,?)";
		    PreparedStatement pstmt;
		    try {
		        pstmt = (PreparedStatement) conn.prepareStatement(sql);
		        pstmt.setString(1, "aa");
		        pstmt.setString(2, "1");
		        pstmt.setString(3, "10");
		        i = pstmt.executeUpdate();
		        pstmt.close();
		        conn.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    
		    System.out.print("insert "+i);
	}
	
	@Test
	public void testUpdate() throws SQLException {
		Connection conn = getConn();
	    int i = 0;
	    String sql = "update student set age='" + 111 + "' where name='" + "aa" + "'";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        i = pstmt.executeUpdate();
	        System.out.println("resutl: " + i);
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    System.out.print("update "+i);
	}
	
	//@Test
	public void testDelete() throws SQLException {
		Connection conn = getConn();
	    int i = 0;
	    String sql = "delete from student where Name='" + "aa" + "'";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        i = pstmt.executeUpdate();
	        System.out.println("resutl: " + i);
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	@Test
	public void testGetAll() throws SQLException {
		
		Connection conn = getConn();
	    String sql = "select * from student";
	    PreparedStatement pstmt;
	    
	    try {
	        pstmt = (PreparedStatement)conn.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();
	        int col = rs.getMetaData().getColumnCount();
	        System.out.println("============================");
	        while (rs.next()) {
	            for (int i = 1; i <= col; i++) {
	                System.out.print(rs.getString(i) + "\t");
	                if ((i == 2) && (rs.getString(i).length() < 8)) {
	                    System.out.print("\t");
	                }
	             }
	            System.out.println("");
	        }
	            System.out.println("============================");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	}
	
}
