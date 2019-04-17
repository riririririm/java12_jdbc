package com.rim.db.test;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

import com.rim.db.util.DBConnector;

public class DBConnectorTest {
	//Annotation : 설명+실행 기능 >> 생략시 실행x / 일반 메서드
	@Test
	public void test() throws Exception {
		Connection conn = DBConnector.getConnect();
		assertNotNull(conn); //null이 아니면 test성공
		//assertNull(conn); //null이면 test성공
	}

}
