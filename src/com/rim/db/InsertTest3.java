package com.rim.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class InsertTest3 {

	public static void main(String[] args) {
		// 1. DB연결 로그인
		String user = "scott";
		String pwd = "tiger";
		String url = "jdbc:oracle:thin:@211.238.142.25:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		Connection conn = null;
		Statement st = null;
		int result = 0;
		Scanner sc = new Scanner(System.in);
		
		
		try {
			//2. driver를 메모리에 로딩하는 작업
			Class.forName(driver);
			System.out.println("드라이버 로딩 성공");
			
			//3. DB서비스에 접속해서 로그인해서 Connection 받기
			conn = DriverManager.getConnection(url, user, pwd);
			System.out.println("DB연결 성공");
			
			//4.Query문 생성 (쿼리문의 ;은 생략한다)
			System.out.println("empno : ");
			String empno= sc.next();
			System.out.println("ename:");
			String ename= sc.next();
			System.out.println("job:");
			String job = sc.next();
			System.out.println("mgr:");
			String mgr = sc.next();
			Calendar cal  = Calendar.getInstance();
			String pattern = "yy/MM/dd";
			SimpleDateFormat sd = new SimpleDateFormat(pattern);
			Date date = cal.getTime();
			String d = sd.format(date);
			
			String sql = "insert into emp values("+empno+",'"+ename+"','"+job+"',"
					+mgr+",'"+d+"',1000,0,30)";			
			
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
			System.out.println("insert성공");
		else
			System.out.println("insert실패");
		
		
				
		
		
		

	}

}
