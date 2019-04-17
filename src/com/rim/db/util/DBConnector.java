package com.rim.db.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DBConnector {
	
	//Connection
	public static Connection getConnect() throws Exception {
		String user ="user01";
		String pwd = "user01";
		String url="jdbc:oracle:thin:@211.238.142.24:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, user, pwd);
		
		return conn;
	}
	
	//Close
	public static void disConnect(PreparedStatement pst, Connection conn) throws Exception{
		pst.close();
		conn.close();
	}
	
	
	public static void disConnect(ResultSet rs, PreparedStatement pst, Connection conn) throws Exception{
		rs.close();
		DBConnector.disConnect(pst, conn);
	}
	
}
