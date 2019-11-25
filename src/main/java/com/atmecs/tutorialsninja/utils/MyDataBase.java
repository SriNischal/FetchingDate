package com.atmecs.tutorialsninja.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class MyDataBase {

	ResultSet rs = null;
	Statement stmt = null;
	Connection con = null;
	PreparedStatement pstmt=null;
	String expectedvalue;

	public String db(String databaseName, String tableName, String columnName, int rowNo) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager
					.getConnection("jdbc:mysql://127.0.0.1:3306/" + databaseName + "?user=root&password=Nischal-4144");

			stmt = con.createStatement();

		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			rs = stmt.executeQuery("select * from "+ tableName);
			/*
									 * 
									 * pstmt=con.prepareStatement("insert into project (id,name) values(?,?)");
									 * pstmt.setInt(1, 2); pstmt.setString(2, "MacBook Air"); pstmt.executeUpdate();
									 */
			while (rs.next()) {
				String getAllIndex = rs.getString(1);
				int row = Integer.parseInt(getAllIndex);
				if (row == rowNo) {
					expectedvalue = rs.getString(columnName);
				}

			}
			con.close();
		} catch (Exception e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return expectedvalue;
	}

	public static void main(String[] args) {
		MyDataBase dataBase = new MyDataBase();
		String s = dataBase.db("assessment", "project", "name", 1);
		System.out.println(s);
	}
}


//databasename
//select columnName
//from tableName
//where rowindex=1;