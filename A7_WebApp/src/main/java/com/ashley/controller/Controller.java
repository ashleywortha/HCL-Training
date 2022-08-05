package com.ashley.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.ashley.model.Model;

@WebServlet("/Create")
public class Controller extends HttpServlet {
	protected void doCreate(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException, SQLException{
//		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		 int id=Integer.parseInt(req.getParameter("aid"));
		 String name=req.getParameter("aname");
		 int age = Integer.parseInt(req.getParameter("aage"));
		 
		 Model u1=new Model();
		 u1.setId(id);
		 u1.setName(name);
		 u1.setAge(age);
		 req.setAttribute("abc", u1);
		 u1.insertEmp();
		 
		 RequestDispatcher rd = req.getRequestDispatcher("create.jsp");
		 rd.forward(req, res);
		 
//		 boolean status=u1.validateUserNamePwd();//model
//		 if(status) {
//			 RequestDispatcher rd=req.getRequestDispatcher("success.jsp");
//			 rd.forward(req, res);
//		
//		 }else {
//			 RequestDispatcher rd=req.getRequestDispatcher("failure.jsp");
//			 rd.forward(req, res);			 
//		 }
	} 
//		 protected void doGet(HttpServletRequest req,HttpServletResponse res)
//					throws ServletException,IOException{
//			 doPost(req,res);
//		 }

}
