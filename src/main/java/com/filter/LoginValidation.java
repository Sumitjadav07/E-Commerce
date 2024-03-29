package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/LoginServlet")
public class LoginValidation implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		System.out.println("Filter is Called");
		
		String uname = request.getParameter("username");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		
		boolean isValid = true;
		String unameError = "";
		String emailError = "";
		String passError = "";
		
		if ( uname == null || uname.trim().length() == 0 ) {
			isValid = false;
			unameError = "Please enter username";
			
		} 
		
		if(email == null || email.trim().length() == 0) {
			isValid = false;
			emailError = "Please enter email-id";
			
		}
		
		if(pass == null || pass.trim().length() == 0) {
			isValid = false;
			passError = "Please enter password";
			
		}
		
		if(isValid) {
			chain.doFilter(request, response);
		} else {
			request.setAttribute("unameError", unameError);
			request.setAttribute("emailError", emailError);
			request.setAttribute("passError", passError);
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
