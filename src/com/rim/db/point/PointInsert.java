package com.rim.db.point;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PointInsert {

	public static void main(String[] args) {
		// id,국,영,수 입력받아서 insert

		String user = " user01";
		String password = "user01";
		String url = "jdbc:oracle:thin:@211.238.142.24:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";

		Connection conn = null;
		PreparedStatement pst = null;

		String id=null;
		int kor,eng,math,result = 0;

		Scanner sc = new Scanner(System.in);

		try {
			Class.forName(driver);
			System.out.println("드라이버ok");
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("디비연결 ok");

			String sql = "insert into point values(?,?,?,?,?,?)";
			pst = conn.prepareStatement(sql);

			System.out.println("id:");
			id = sc.next();
			System.out.println("kor:");
			kor = sc.nextInt();
			System.out.println("eng:");
			eng = sc.nextInt();
			System.out.println("math:");
			math = sc.nextInt();

			pst.setString(1, id);
			pst.setInt(2, kor);
			pst.setInt(3, eng);
			pst.setInt(4, math);
			pst.setInt(5, 0);
			pst.setDouble(6, 0.0);

			result = pst.executeUpdate();

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

		if (result > 0) 
			System.out.println("insert성공");
		else
			System.out.println("insert실패");
	}

}
