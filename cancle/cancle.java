package com.cancle;

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


@WebServlet("/cancle")
public class cancle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("Text/html");
	PrintWriter pw=response.getWriter();
	String i=request.getParameter("id");
	Bean b=new Bean();
	b.setId(i);
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/grocery","root","1234");
		PreparedStatement st=con.prepareStatement("Delete from book where id=?");
		st.setString(1, i);
		int k=st.executeUpdate();
		if(k>0) {
			
			pw.print("-----------YOUR ORDER CANCLE SUCCESSFULLY------------");
		}else {
			pw.print("------------------------YOUR ORDER CAN NOT BE CANCLE---------------");
		}
		
		
	}catch(Exception e){
		pw.print(e);
		
	}
	
	}

}
