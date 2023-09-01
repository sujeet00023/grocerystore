package com.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.Bean;


@WebServlet("/adminregister")
public class adminregister extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("Text/html");
		PrintWriter pw=response.getWriter();
		
		String u=request.getParameter("username");
		
		String p=request.getParameter("password");
		
		Bean b=new Bean();
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/grocery","root","1234");
			
			PreparedStatement st=con.prepareStatement("insert into admin values(?,?) ");
			
			st.setString(1, u);
			st.setString(2, p);
			
			int k=st.executeUpdate();
			if(k>0) {
				pw.print("ADMIN REGISTER SUCCESSFULLY");
			}else {
				pw.print("INVALID INPUT");
			}
			
		}catch(Exception e) {
			pw.print(e);
		}
		
		
		pw.print("");
	}

}
