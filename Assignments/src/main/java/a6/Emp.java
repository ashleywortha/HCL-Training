package a6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Emp {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
//		st.execute("Create table emp(id int(10), name varchar(100), age int(3), primary key(id));");
//		st.execute("insert into emp values(1, 'Logan', 70);");
//		st.execute("insert into emp values(2, 'Tom', 37);");
//		st.execute("insert into emp values(3, 'Shiv', 35);");
//		st.execute("insert into emp values(4, 'Connor', 25);");
//		st.execute("insert into emp values(5, 'Roman', 33);");
//		st.execute("insert into emp values(6, 'Kendall', 40);");
		
		Scanner s = new Scanner(System.in);
		
		int id;
		String name;
		int age;
		boolean exit = false;
		
		System.out.println("Welcome to the Employee Database!");
		while(!exit) {
			System.out.println("Commands: NEW, SEARCH, UPDATE, DELETE, ALL, EXIT");
			
			String cmd = s.next();
			switch(cmd) {
			case "NEW":
				System.out.println("Inserting a new employee into the database");
				System.out.println("Employee ID: ");
				id = s.nextInt();
				System.out.println("Employee name: ");
				name = s.next();
				System.out.println("Employee age: ");
				age = s.nextInt();
				insertEmp(id, name, age);
				break;
				
			case "SEARCH":
				System.out.println("Search for employee by ID");
				System.out.println("Employee ID: ");
				id = s.nextInt();
				getEmp(id);
				break;
				
			case "UPDATE":
				System.out.println("Update Employee's Name");
				System.out.println("Employee ID: ");
				id = s.nextInt();
				System.out.println("Update name to: ");
				name = s.next();
				updateEmp(id, name);
				
				break;
				
			case "DELETE":
				System.out.println("Delete Employee from Database");
				System.out.println("Employee ID: ");
				id = s.nextInt();
				deleteEmp(id);
				break;
				
			case "ALL":
				viewAll();
				break;
				
			case "EXIT":
				exit = true;
				s.close();
				System.out.println("Thanks for using the Employee Database!");
				break;
			default: 
				System.out.println("Command not recognized, please try again");
			}
			
		}
	}
	
	static void insertEmp(int id, String name, int age) throws SQLException {
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
