package com.rim.db.point;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.rim.db.util.DBConnector;

public class PointDAO {
	//메서드명 insert
	public int insert(PointDTO dto) throws Exception {
		Connection conn = DBConnector.getConnect();
		
		String sql = "insert into point values(?,?,?,?,?,?,?,?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		
		pst.setInt(1, dto.getNum());
		pst.setString(2, dto.getSid());
		pst.setInt(3, dto.getKor());
		pst.setInt(4, dto.getEng());
		pst.setInt(5, dto.getMath());
		pst.setInt(6, dto.getTotal());
		pst.setDouble(7, dto.getAvg());
		pst.setInt(8, dto.getBnum());
		
		int result =pst.executeUpdate();
		
		DBConnector.disConnect(pst, conn);
		
		return result;
	}
	
	//delete
	public int delete() throws Exception{
		
		return 0;
	}

}
