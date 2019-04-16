package com.rim.db.pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectTest1 {

	public static void main(String[] args) {
		//부서번호 입력받아서 dept에서 검색
		//1.로그인정보
		String user = "scott";
		String pwd = "tiger";
		String url ="jdbc:oracle:thin:@211.238.142.25:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		Scanner sc = new Scanner(System.in);
		
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pst = null;
		int result=0;
	
		
		try {
			//2. 드라이버를 메모리에 로딩
			Class.forName(driver);
			
			//3. 로그인 후 connection 객체 받아오기
			conn = DriverManager.getConnection(url, user, pwd);
			
			//4. sql문 작성
			String sql = "select * from dept where deptno=?";
		
			//5. sql문 db에 미리 전송
			pst = conn.prepareStatement(sql);
			
			//6. ?에 대한 값을 셋팅
			System.out.println("부서번호:");
			int deptno = sc.nextInt();
			pst.setInt(1, deptno);
			
			//7. 최종 전송 후 결과처리
			rs = pst.executeQuery();
			
			if(rs.next()) {
				System.out.println("부서번호:"+ rs.getInt("deptno"));
				System.out.println("부서명:"+rs.getString("dname"));
				System.out.println("지역명:"+rs.getString("loc"));
				System.out.println();
			}else {
				System.out.println("없는부서명");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		
		
		

	}

}
