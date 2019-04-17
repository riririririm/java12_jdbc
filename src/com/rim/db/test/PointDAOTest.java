package com.rim.db.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.Test;

import com.rim.db.point.PointDAO;
import com.rim.db.util.DBConnector;

public class PointDAOTest {

	@Test
	public void test() throws Exception {
		PointDAO dao = new PointDAO();
		
		//int result = dao.insert();
		//assertEquals(1, result);
	}

}
