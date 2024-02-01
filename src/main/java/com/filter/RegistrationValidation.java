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
		if(fullname == null || fullname.trim().length() == 0) {
			fullnameError = "Please enter fullname";
			request.setAttribute("fullnameError", fullnameError);
		}
		
		if (fullname.matches("[A-Za-z]+") == false) {
			fullnameError = "Fullname must be alphabatical";
			request.setAttribute("fullnameError", fullnameError);
		}
		return "";
	}

	protected String usernameValidation(String uname , ServletRequest request) {
		String unameError = "";
		if (uname == null || uname.trim().length() == 0) {
			unameError = "Please enter username";
			request.setAttribute("unameError", unameError);
		} 
		
		if (uname.matches("^[A-Za-z0-9]*$") == false) {
			unameError = "Username must contains alphabets and numbers only ";
			request.setAttribute("unameError", unameError);
		}
		return "";
	}

	protected String emailValidation(String email , ServletRequest request) {
		String emailError = "";
		if (email == null || email.trim().length() == 0) {
			emailError = "Please enter email-id";
			request.setAttribute("emailError", emailError);
		} 
		
		if (email.matches("[a-zA-Z0-9]+@[a-zA-Z]+\\.[a-zA-Z]{2,5}") == false) {
			emailError = "Please enter valid email-id";
			request.setAttribute("emailError", emailError);
		}
		return "";
	}

	protected String mnumberValidation(String mnumber , ServletRequest request) {

		String mnumberError = "";

		if (mnumber == null || mnumber.trim().length() == 0) {
			mnumberError = "Please Enter Mobile Number";
			request.setAttribute("mnumberError", mnumberError);
		}

		if (mnumber.length() != 10) {
			mnumberError = "Mobile number should ne 10 digits";
			request.setAttribute("mnumberError", mnumberError);
		} 
		
		if (mnumber.matches("[0-9]+")) {
			mnumberError = "Please enter valid mobile number";;
			request.setAttribute("mnumberError", mnumberError);
		}
		return "";
	}

	protected String passwordValidation(String pass , ServletRequest request) {

		String passError = "";
		if (pass.length() < 8 || pass.length() > 16) {
			passError = "Password must be between 8 to 16 characters";
			request.setAttribute("passError", passError);
		}

		if (pass == null || pass.trim().length() == 0) {
			passError = "Please enter password";
			request.setAttribute("passError", passError);
		}

		if (pass.matches(".*[A-Z]*.") == false) {
			passError = "Password must have one uppercase letter";
			request.setAttribute("passError", passError);
		}

		if (pass.matches(".*[a-z]*.") == false) {
			passError = "Password must have one lowercase letter";
			request.setAttribute("passError", passError);
		}

		if (pass.matches(".*[0-9]*.") == false) {
			passError = "Password must have one number";
			request.setAttribute("passError", passError);
		}

		if (pass.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*")) {
			passError =  "Password must have one special character";
			request.setAttribute("passError", passError);
		}

		return "";

	}

	// protected String cpassValidation(String cpass) {
	//
	// if(cpass.matches() == false) {
	//
	// }
	//
	// return null;
	//
	// }

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
