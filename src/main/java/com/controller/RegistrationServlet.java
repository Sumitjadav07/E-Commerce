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

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Get Registration Data
		String fullname = request.getParameter("fullname");
		String uname = request.getParameter("username");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String pass = request.getParameter("password");
		// String confirmpass = request.getParameter("confirmpassword");
		String gender = request.getParameter("gender");
		
		// Get Database Connection
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/e_commerce";
		String username = "root";
		String password = "root";
		
		try {
			
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection( url , username , password);
			
			// Set Insert Query to insert Registration Data
			PreparedStatement smst = conn.prepareStatement("insert into registration_data ( fullname , username , email , mobile_number , password , gender ) values ( ? , ? , ? , ? , ? , ? )");
			smst.setString(1,fullname);
			smst.setString(2,uname);
			smst.setString(3,email);
			smst.setString(4,mobile);
			smst.setString(5,pass);
			smst.setString(6,gender);
			
			int record = smst.executeUpdate();
			
			if(record == 1) {
				System.out.println("Registration Successfull :)");
			} else {
				System.out.println("Registration Failed :(");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("Registration.jsp").forward(request, response);
		
	}

}
