package com.msp.spring.jdbc;

import static org.junit.Assert.*;

import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class JDBCTemplateTest {

	private ApplicationContext ctx = null;
	private JdbcTemplate jdbcTemplate;
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
	}

	@Test
	public void testUpdate() {

		String sql = "UPDATE student SET name = ? WHERE id=?";
		jdbcTemplate.update(sql,"aa","1");
		System.out.println("update...");
 
	}
	
	@Test
	public void testDataSource() throws SQLException {

//		DataSource datasource = (DataSource) ctx.getBean("dataSource");
//		Connection conn = (Connection) datasource.getConnection();
//		System.out.println(conn);
//		
//		ResultSet tabs = null;  
//		
//		
//		 try {  
//		        DatabaseMetaData dbMetaData = conn.getMetaData();  
//		        String[]   types   =   { "TABLE" }; 
//		        
//		        tabs = dbMetaData.getTables(null, null, "test", types);  
//		        if (tabs.next()) {  
//		        	System.out.println("table test exist");
//		        }  
//		    } catch (Exception e) {  
//		        e.printStackTrace();  
//		    }finally{  
//		        tabs.close();  
//		        conn.close();  
//		    }  
//		
	}


}
