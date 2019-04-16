package com.rim.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertTest2 {

	public static void main(String[] args) {
		// 1. DB연결 로그인
		String user = "scott";
		String pwd = "tiger";
		String url = "jdbc:oracle:thin:@211.238.142.25:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";

		Connection conn =null;
		Statement st = null;
		int result=0;
		
		Scanner sc = new Scanner(System.in);
		
		
		try {
			//2. driver를 메모리에 로딩하는 작업
			Class.forName(driver);
			System.out.println("드라이버 로딩 성공");
			
			//3. DB서비스에 접속해서 로그인해서 Connection 받기
			conn = DriverManager.getConnection(url, user,pwd);
			System.out.println("DB연결 성공");
			
			//4.Query문 생성 (쿼리문의 ;은 생략한다)
			System.out.println("부서번호");
			String deptno = sc.next();
			System.out.println("부서명");
			String dname = sc.next();
			System.out.println("지역명");
			String loc = sc.next();
			
			String sql = "insert into dept values ("+deptno+", '"+dname+"', '"+loc+"')";
			
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
			System.out.println("insert 성공");
		else
			System.out.println("insert 실패");
				
		
		
		

	}

}
