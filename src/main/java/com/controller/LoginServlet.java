package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	private static final String url = "jdbc:mysql://localhost:3306/e_commerce";
	private static final String username = "root";
	private static final String password = "root";
 
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uname = request.getParameter("username");
		String mnumber = request.getParameter("mobile");
		String pass = request.getParameter("pass");
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection( url , username , password);
			
			String query = "select username , mobile_number , password from registration_data where username = ?";
			PreparedStatement smst = conn.prepareStatement(query);
			smst.setString(1, uname);
				
			ResultSet rs = smst.executeQuery();
			
			if(rs.next()) {
				
				String storedPassword = rs.getString("password");
				
				if(storedPassword.equals(pass)) {
					
					String storedMobile = rs.getString("mobile_number");
					
					if(storedMobile.equals(mnumber)) {
						
						//Successfully Login
						System.out.println("Successfully Login!!!");
						
					} else {
						
						System.out.println("Invalid Mobile Number");
					}
					
				} else {
					//Failed Login
					System.out.println("Invalid Password");
				}
				
			} else {
				System.out.println("Username not found");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("Login.jsp").forward(request, response);
		
	}

}
