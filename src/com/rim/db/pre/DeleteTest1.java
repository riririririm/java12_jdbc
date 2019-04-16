package com.rim.db.pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteTest1 {

	public static void main(String[] args) {
		//부서번호 입력받아서 dept에서 삭제
		//1.로그인정보
		String user = "scott";
		String password ="tiger";
		String url = "jdbc:oracle:thin:@211.238.142.25:1521:xe";
		String driver ="oracle.jdbc.driver.OracleDriver";
		
		Scanner sc = new Scanner(System.in);
		
		Connection conn =null;
		PreparedStatement pst = null;
		int result =0;
		
		
		//2. 드라이버를 메모리에 로딩
		try {
			Class.forName(driver);
			System.out.println("드라이버 로딩성공");
			
			//3. 로그인 후 connection 객체 받아오기
			conn = DriverManager.getConnection(url, user, password);
			
			//4. sql문 작성
			String sql = "delete dept where deptno=?";
			
			//5. sql문 db에 미리 전송
			pst=conn.prepareStatement(sql);
			
			//6. ?에 대한 값을 셋팅
			System.out.println("부서번호:");
			int deptno = sc.nextInt();
			pst.setInt(1, deptno);
			
			//7. 최종 전송 후 결과처리
			result = pst.executeUpdate();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				conn.close();				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		if(result>0)
			System.out.println("delete 성공");
		else
			System.out.println("delete 실패");
		
		

	}

}
