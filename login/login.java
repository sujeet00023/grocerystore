package com.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.Bean;


@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("Text/html");
		PrintWriter pw=response.getWriter();
		
		String i=request.getParameter("id");
		
		String p=request.getParameter("password");
		
		Bean b=new Bean();
		b.setId(i);
		b.setPassword(p);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/grocery","root","1234");
			PreparedStatement st= con.prepareStatement("select id,password from register where id=? and password=? ");
			
			st.setString(1, i);
			st.setString(2, p);
			ResultSet rs=st.executeQuery();
			if(rs.next()) 
			{
			if(i.equals(rs.getString(1)) && p.equals(rs.getString(2))) {
				RequestDispatcher rd=request.getRequestDispatcher("success.html");

				rd.forward(request, response);
				
			}
			}else {
				RequestDispatcher rd=request.getRequestDispatcher("invalid.html");
				rd.forward(request, response);
			}
			
		}catch(Exception e) {
			pw.print(e);
		}
		
		
	}

}
