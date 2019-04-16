package com.rim.db.pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertTest1 {

	public static void main(String[] args) {
		//1.로그인정보
		String user ="scott";
		String pwd = "tiger";
		String url="jdbc:oracle:thin@211.238.142.25:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		Scanner sc = new Scanner(System.in);
		
		Connection conn = null;
		PreparedStatement st = null;
		
		int deptno=0;
		String dname="";
		String loc="";
		
		int result=0;
		
		//2. 드라이버를 메모리에 로딩
		try {
			Class.forName(driver);
			
			//3. 로그인 후 connection 객체 받아오기
			conn = DriverManager.getConnection(url, user, pwd);
			
			//4. sql문 작성
			String sql = "insert into dept values(?,?,?)";
			
			//5. sql문 db에 미리 전송
			st = conn.prepareStatement(sql);
			
			//6. ?에 대한 값을 셋팅
			//setXXX(?의 인덱스번호, 해당하는 값)
			System.out.println("deptno:");
			deptno = sc.nextInt();
			System.out.println("dname:");
			dname = sc.next();
			System.out.println("loc:");
			loc = sc.next();
			
			st.setInt(1, deptno);
			st.setString(2, dname);
			st.setString(3, loc);
			
			//7. 최종 전송 후 결과처리
			result = st.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				st.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(result>0)
			System.out.println("insert 성공");
		else
			System.out.println("insert 실패");
		

	}

}
