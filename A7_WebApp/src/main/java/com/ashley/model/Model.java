package com.ashley.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//MODEL->POJO and your business logic
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Model {
	
	private int id;
	private String name;
	private int age;
	
	public void insertEmp() throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/julyfsd", "root", "l0v3SQL:)");
		PreparedStatement pst = con.prepareStatement("insert into emp values(?,?,?)");
		pst.setInt(1, id); 
		pst.setString(2, name); 
		pst.setInt(3, age);
		pst.executeUpdate();
		System.out.println(id + ", " + name + ", " + age + " added to the database!");
		
	}
	
	static void deleteEmp(int id) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/julyfsd", "root", "l0v3SQL:)");
		
		PreparedStatement pst = con.prepareStatement("delete from emp where id=?");
		pst.setInt(1, id); 
		pst.executeUpdate();
		
		System.out.println(id + " removed from the database!");
		
	}
	
	static void updateEmp(int id, String name) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/julyfsd", "root", "l0v3SQL:)");
		PreparedStatement pst = con.prepareStatement("update emp set name=? where id=?");
		pst.setString(1, name);
		pst.setInt(2, id);
		pst.executeUpdate();
		System.out.println("updated " + id + " name to " + name);
		
	}
	
	
	static void getEmp(int id) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/julyfsd", "root", "l0v3SQL:)");
		PreparedStatement pst = con.prepareStatement("select *  from emp where id=?");
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3));
		}
				
	}
	
	static void viewAll() throws SQLException {
		System.out.println("Current Employee Table:");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/julyfsd", "root", "l0v3SQL:)");
		PreparedStatement pst = con.prepareStatement("select * from emp");
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3));
		}
		
	}
	


}
