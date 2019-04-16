package com.rim.db.pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectTest3 {

	public static void main(String[] args) {
		//1.로그인정보
		String user = "scott";
		String password = "tiger";
		String url = "jdbc:oracle:thin:@211.238.142.25:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		Connection conn=null;
		PreparedStatement pst = null;
		
		ResultSet rs = null;
		
		//2. 드라이버를 메모리에 로딩
		try {
			Class.forName(driver);
			
			//3. 로그인 후 connection 객체 받아오기
			conn = DriverManager.getConnection(url, user, password);
			
			//4. sql문 작성
			String sql = "select count(deptno), max(deptno), min(deptno) from dept";
			
			//5. sql문 db에 미리 전송
			pst = conn.prepareStatement(sql);
			
			//7. 최종 전송 후 결과처리
			rs = pst.executeQuery();
			
			rs.next();
				/*
				System.out.println("부서 개수:"+rs.getString("count(deptno)"));
				System.out.println("최대값:"+rs.getString("max(deptno)"));
				System.out.println("최소값:"+rs.getString("min(deptno)"));
				*/
				System.out.println("부서 개수:"+rs.getInt(1));
				System.out.println("최대값:"+rs.getInt(2));
				System.out.println("최소값:"+rs.getInt(3));
			
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pst.close();
				conn.close();
								
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		

	}

}
