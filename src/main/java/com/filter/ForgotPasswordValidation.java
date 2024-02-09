package com.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/ForgotPasswordServlet")
public class ForgotPasswordValidation implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("Filter is Called");
		// TODO Auto-generated method stub
		String uname = request.getParameter("uname");
		String newpass = request.getParameter("newpass");
		String cnewpass = request.getParameter("confirmnewpass");
		
		
		List<String> errors = new ArrayList<String>();
		
		if(  usernameValidation( uname , request).isEmpty() == false) {
			errors.add(usernameValidation( uname , request));
		}
		
		if(  newpassValidation( newpass , request).isEmpty() == false) {
			errors.add(newpassValidation( newpass , request));
		}
		
		if(  cnewpassValidation( newpass , cnewpass , request).isEmpty() == false) {
			errors.add(cnewpassValidation( newpass , cnewpass , request));
		}
		
		if( errors.isEmpty() == false) {
			request.setAttribute("validationErrors", errors);
			request.getRequestDispatcher("ForgotPassword.jsp").forward(request, response);
		} else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	protected String usernameValidation(String uname , ServletRequest request) {
		String unameError = "";
		String usernameRegEx = "^(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z0-9]{3,20}$";
		if (uname == null || uname.trim().length() == 0) {
			unameError = "Please enter username";
			request.setAttribute("unameError", unameError);
			return unameError;
		} 
		
		if (uname.matches(usernameRegEx) == false) {
			unameError = "Username must contains only characters and numbers";
			request.setAttribute("unameError", unameError);
			return unameError;
		}
		return "";
	}
	
	protected String newpassValidation(String newpass , ServletRequest request) {

		String newpassError = "";
		if(newpass == null || newpass.trim().length() == 0) {
			newpassError = "Please Enter Password";
			request.setAttribute("newpassError",newpassError);
			return newpassError;
		}
		
		if(newpass.length() < 8 || newpass.length() > 16){
			newpassError = "Password should be between 8 and 16 characters long";
			request.setAttribute("newpassError",newpassError);
			return newpassError;
		}
		
		if(newpass.matches(".*[0-9].*") == false){
			newpassError = "Password must have atleast One Digit";
			request.setAttribute("newpassError",newpassError);
			return newpassError;
		}
		if(newpass.matches(".*[A-Z].*") == false){
			newpassError = "Password must have atleast One Upper Character";
			request.setAttribute("newpassError",newpassError);
			return newpassError;
		}
		if(newpass.matches(".*[a-z].*") == false){
			newpassError = "Password must have atleast One Lower Character";
			request.setAttribute("newpassError",newpassError);
			return newpassError;
		}
		if(newpass.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*") == false){
			newpassError = "Password must have atleast One Special Character";
			request.setAttribute("newpassError",newpassError);
			return newpassError;
		}
		return "";

	}

	 protected String cnewpassValidation(String newpass , String cnewpass , ServletRequest request) {
		
		 String cnewpassError = "";
		 if (cnewpass == null ||cnewpass.trim().length() == 0) {
				cnewpassError = "Please enter confirm password";
				request.setAttribute("cnewpassError",cnewpassError);
				return cnewpassError;
			}
		 
		 if(cnewpass.equals(newpass) == false) {
			 cnewpassError = "Confirm password must be match with password";
			 request.setAttribute("cnewpassError" , cnewpassError);
			 return cnewpassError;
		 }
		
		return "";
	 }

}
