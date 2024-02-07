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

@WebFilter("/RegistrationServlet")
public class RegistrationValidation implements Filter {

	protected String fullNameValidation(String fullname , ServletRequest request) {
		String fullnameError = "";
		String fullnameRegEx = "^[a-zA-Z]+(([ ][a-zA-Z ])?[a-zA-Z]*)*$\r\n";
		if(fullname == null  ||  fullname.trim().length() == 0) {
			fullnameError = "Please enter fullname";
			request.setAttribute("fullnameError", fullnameError);
			return fullnameError;
		}
		
		if (fullname.matches(fullnameRegEx) == false) {
			fullnameError = "Fullname only contains characters";
			request.setAttribute("fullnameError", fullnameError);
			return fullnameError;
		}
		return "";
	}

	protected String usernameValidation(String uname , ServletRequest request) {
		String unameError = "";
		String usernameRegEx = "^[a-zA-Z0-9]+$";
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

	protected String emailValidation(String email , ServletRequest request) {
		String emailError = "";
		String emailRegEx = "[a-zA-Z0-9]+@[a-zA-Z]+\\\\.[a-zA-Z]{2,5}";
		if (email == null || email.trim().length() == 0) {
			emailError = "Please enter email-id";
			request.setAttribute("emailError", emailError);
			return emailError;
		} 
		
		if (email.matches(emailRegEx) == false) {
			emailError = "Please enter valid email-id";
			request.setAttribute("emailError", emailError);
			return emailError;
		}
		return "";
	}

	protected String mnumberValidation(String mnumber , ServletRequest request) {

		String mnumberError = "";
		String mnumberRegEx = "^\\+[0-9]{1,3}[0-9]{6,14}$\r\n";
		if (mnumber == null || mnumber.trim().length() == 0) {
			mnumberError = "Please enter mobile number";
			request.setAttribute("mnumberError", mnumberError);
			return mnumberError;
		}
		if (mnumber.matches(mnumberRegEx)) {
			mnumberError = "Mobile number should be 10 digits";;
			request.setAttribute("mnumberError", mnumberError);
			return mnumberError;
		}
		return "";
	}

	protected String passwordValidation(String pass , ServletRequest request) {

		String passError = "";
		if(pass == null || pass.trim().length() == 0) {
			passError = "Please Enter Password";
			request.setAttribute("passError",passError);
			return passError;
		}
		
		if(pass.length() < 8 || pass.length() > 16){
			passError = "Password should be between 8 and 16 characters long";
			request.setAttribute("passError",passError);
			return passError;
		}
		
		if(pass.matches(".*[0-9].*") == false){
			passError = "Password must have atleast One Digit";
			request.setAttribute("passError",passError);
			return passError;
		}
		if(pass.matches(".*[A-Z].*") == false){
			passError = "Password must have atleast One Upper Character";
			request.setAttribute("passError",passError);
			return passError;
		}
		if(pass.matches(".*[a-z].*") == false){
			passError = "Password must have atleast One Lower Character";
			request.setAttribute("passError",passError);
			return passError;
		}
		if(pass.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*") == false){
			passError = "Password must have atleast One Special Character";
			request.setAttribute("passError",passError);
			return passError;
		}
		return "";

	}

	 protected String cpassValidation(String pass , String cpass , ServletRequest request) {
		
		 String cpassError = "";
		 if (cpass == null ||cpass.trim().length() == 0) {
				cpassError = "Please enter confirm password";
				request.setAttribute("cpassError",cpassError);
				return cpassError;
			}
		 
		 if(cpass.equals(pass) == false) {
			 cpassError = "Confirm password must be match with password";
			 request.setAttribute("cpassError" , cpassError);
			 return cpassError;
		 }
		
		return "";
	 }

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub

		System.out.println("Filter is Called");

		String fullname = request.getParameter("fullname");
		String uname = request.getParameter("username");
		String email = request.getParameter("email");
		String mnumber = request.getParameter("mobile");
		String pass = request.getParameter("password");
		String cpass = request.getParameter("confirmpassword");
		
		List<String> errors = new ArrayList<String>();
		
		if(  fullNameValidation( fullname , request).isEmpty() == false) {
			errors.add(fullNameValidation( fullname , request));
		}
		
		if(  usernameValidation( uname , request).isEmpty() == false) {
			errors.add(usernameValidation( uname , request));
		}

		if(  emailValidation( email , request).isEmpty() == false) {
			errors.add(emailValidation( email , request));
		}
		
		if(  mnumberValidation( mnumber , request).isEmpty() == false) {
			errors.add(mnumberValidation( mnumber , request));
		}
		
		if(  passwordValidation( pass , request).isEmpty() == false) {
			errors.add(passwordValidation( pass , request));
		}
		
		if(  cpassValidation( pass , cpass , request).isEmpty() == false) {
			errors.add(cpassValidation( pass , cpass , request));
		}
		
		if( errors.isEmpty() == false) {
			request.setAttribute("validationErrors", errors);
			request.getRequestDispatcher("Registration.jsp").forward(request, response);
		} else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
