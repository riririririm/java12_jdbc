package com.rim.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTest1 {

	public static void main(String[] args) {
		// 1. DB연결 로그인
		String user = "scott";
		String pwd = "tiger";
		String url = "jdbc:oracle:thin:@211.238.142.25:1521:xe"; //xe는 SID.DBA가 변경할 수 있음
		String driver = "oracle.jdbc.driver.OracleDriver";
		Connection conn=null;
		Statement st = null;
		int result=0;
		
		
		try {
			//2. driver를 메모리에 로딩하는 작업
			Class.forName(driver); //driver라는 이름의 문자열을 객체로 만들어줌
			System.out.println("로딩 성공");
			
			//3. DB서비스에 접속해서 로그인해서 Connection 받기
			conn=DriverManager.getConnection(url, user, pwd);
			System.out.println("연결성공");
			
			//4.Query문 생성 (쿼리문의 ;은 생략한다)
			String sql = "insert into dept values(14,'office','busan')";
			
			//5. 전송
			st = conn.createStatement();
			result = st.executeUpdate(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
				
		if(result>0)
			System.out.println("성공");
		else
			System.out.println("실패");
		
		
		

	}

}
