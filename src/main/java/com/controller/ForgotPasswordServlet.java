package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ForgotPasswordServlet")
public class ForgotPasswordServlet extends HttpServlet {
	
	private static final String url = "jdbc:mysql://localhost:3306/e_commerce";
	private static final String username = "root";
	private static final String password = "root";
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname = request.getParameter("uname");
		String newpass = request.getParameter("newpass");
	
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection( url , username , password);
				
				String query = "Update registration_data set password = ? where username = ? ";
				PreparedStatement smst = conn.prepareStatement(query);
				smst.setString(1, newpass);
				smst.setString(2, uname);
				
				int record = smst.executeUpdate();
				
				if(record == 1) {
					
					request.setAttribute("errorMSG", "Password updated successfully");
					System.out.println("Password updated successfully");
					
				} else {
					
					request.setAttribute("errorMSG", "Failed to update password");
					System.out.println("Failed to update password");
				}
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("ForgotPassword.jsp").forward(request, response);

	}

}
