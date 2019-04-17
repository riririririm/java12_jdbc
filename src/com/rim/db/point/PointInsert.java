package com.rim.db.point;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.rim.db.util.DBConnector;

public class PointInsert {

	public static void main(String[] args) throws Exception {
		// id,국,영,수 입력받아서 insert
		new PointController().start();
	}

}
