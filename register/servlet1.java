package com.register;

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


@WebServlet("/servlet1")
public class servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		

		
		
		
		
	}
		
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("Text/html");
		
		String i=request.getParameter("id");
		
		String f=request.getParameter("firstname");
		
		String m=request.getParameter("middlename");
		
		String l=request.getParameter("lastname");
	
		String e=request.getParameter("emailid");
		
		String a=request.getParameter("address");
		
		String mh=request.getParameter("mobilenumber");
		
		String p=request.getParameter("password");
		
		PrintWriter pw=response.getWriter();
		Bean b=new Bean();
		b.setId(i);
		b.setFirstname(f);
		b.setMiddlename(m);
		b.setLastname(l);
		b.setEmailid(e);
		b.setAddress(a);
		b.setMobilenumber(mh);
		b.setPassword(p);
		pw.print("<center>WELCOME</center>");
		
		try {
			
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/grocery","root","1234");
		PreparedStatement st=con.prepareStatement("insert into register values(?,?,?,?,?,?,?,?)");
		
		st.setString(1, i);
		st.setString(2, f);
		st.setString(3, m);
		st.setString(4, l);
		st.setString(5, e);
		st.setString(6, a);
		st.setString(7, mh);
		st.setString(8, p);
		
		
		int k=st.executeUpdate();
		
		if(k>0) {
			
			pw.print("----------------SUCCESSFULLY REGISTERED------------");
	pw.print("<br>");
			pw.print("<center><a href='index.html'>Click Here</a></center>");			
		}else {
	
			pw.print("-------------------");
		}
		
		}catch(Exception e1) {
			pw.print(e1);
		}
		
		
		
		
	}

}
