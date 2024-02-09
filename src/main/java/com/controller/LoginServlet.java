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
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		
		
		String unameError = "";
		String emailError = "";
		String passError = "";
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection( url , username , password);
			
			String query = "select username , email , password from registration_data where username = ?";
//			String query = "select * from registration_data where username = ? and mobile_number = ? and password = ?";
			PreparedStatement smst = conn.prepareStatement(query);
			smst.setString(1, uname);
				
			ResultSet rs = smst.executeQuery();
			
			if(rs.next()) {
				
				String storedPassword = rs.getString("password");
				
				if(storedPassword.equals(pass)) {
					
					String storedEmail = rs.getString("email");
					
					if(storedEmail.equals(email)) {
						
						//Successfully Login
						request.setAttribute("success", "Successfully login");
						
					} else {
						emailError = "Wrong email-ID";
						request.setAttribute("emailError", emailError);
					}
					
				} else {
					//Failed Login
					passError = "Wrong password";
					request.setAttribute("passError", passError);
				}
				
			} else {
				unameError = "Username not found";
				request.setAttribute("unameError", unameError);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("Login.jsp").forward(request, response);
		
	}

}
