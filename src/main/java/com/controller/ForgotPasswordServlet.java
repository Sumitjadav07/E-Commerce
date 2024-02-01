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
		String confirmnewpass = request.getParameter("confirmnewpass");
		String passError = "";
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection( url , username , password);
			
			if(newpass.equals(confirmnewpass)) {
				
				String query = "Update registration_data set password = ? where username = ? ";
				PreparedStatement smst = conn.prepareStatement(query);
				smst.setString(1, newpass);
				smst.setString(2, uname);
				
				int record = smst.executeUpdate();
				
				if(record == 1) {
					
					request.setAttribute("Password updated successfully", passError);
					System.out.println("Password updated successfully");
					
				} else {
					
					request.setAttribute("Failed to update password", passError);
					System.out.println("Failed to update password");
				}
				
			} else {
				
				request.setAttribute("Password and Confirm password do not match", passError);
				System.out.println("Password and Confirm password do not match");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("ForgotPassword.jsp").forward(request, response);

	}

}
