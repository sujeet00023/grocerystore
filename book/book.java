package com.book;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.Bean;


@WebServlet("/book")
public class book extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("Text/html");
		PrintWriter pw=response.getWriter();
		
		String i=request.getParameter("id");
		String f=request.getParameter("firstname");
		String l=request.getParameter("lastname");
		String e=request.getParameter("emailid");
		
		String a=request.getParameter("address");
		
		String q=request.getParameter("quantity");
		String p=request.getParameter("productname");
		String pn=request.getParameter("pincode");
		String m=request.getParameter("mobilenumber");
		
		Bean b=new Bean();
		
		b.setId(i);
		b.setFirstname(f);
		b.setLastname(l);
		b.setEmailid(e);
		b.setAddress(a);
		b.setProduct_name(p);
		b.setQuantity(q);
		b.setPincode(pn);
		b.setMobilenumber(m);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/grocery","root","1234");
			
			PreparedStatement st=con.prepareStatement("insert into book values(?,?,?,?,?,?,?,?,?)");
		
					st.setString(1, i);
			st.setString(2, f);
			st.setString(3, l);
			st.setString(4,e);
			st.setString(5, a);
			st.setString(6, p);
			st.setString(7, q);
			st.setString(8, pn);
			st.setString(9, m);
			int k=st.executeUpdate();
					
					if(k>0) {
						
						
						pw.print("---------ORDER PLACED SUCCESSFULLY---------");
						
						
					}else {
						
						pw.print("------------------Booking Unsuccessfull--------------");
						
					}
		
		pw.print("");
		
	}catch(Exception e1){
		pw.print(e1);
	}
		
	}

}
