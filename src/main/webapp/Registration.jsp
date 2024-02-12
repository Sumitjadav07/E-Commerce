<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="registration.css">
<title>Registration Form</title>
</head>
<body>

	<nav class="navbar">
        <div class="logo">
            <a href="Home.html">E Commerce</a>
        </div>
        <div class="list-items">
            <a href="Home.html">Home</a>
            <a href="AboutUs.html">About us </a>
            <a href="">Products</a>
            <a href="">Blog</a>
        </div>
        <div class="login">
            <a href="Registration.jsp">Sign Up</a>
            <a href="Login.jsp">Log In</a>
        </div>
    </nav>

	<div class="container">
        <div class="title"><span id="element"></span></div>
        <form action="RegistrationServlet" method="post">
            <div class="user-details">
                <div class="input-box">
                    <span class="details">Full Name</span>
                    <input type="text" placeholder="Enter your name" name="fullname">
                    <span class="error-details">${fullnameError}</span>
                </div>
                <div class="input-box">
                    <span class="details">Username</span>
                    <input type="text" placeholder="Enter your username" name="username">
                    <span class="error-details">${unameError}</span>
                </div>
                <div class="input-box">
                    <span class="details">Email</span>
                    <input type="text" placeholder="Enter your email" name="email">
                    <span class="error-details">${emailError}</span>
                </div>
                <div class="input-box">
                    <span class="details">Mobile Number</span>
                    <input type="text" placeholder="Enter your number" name="mobile">
                    <span class="error-details">${mnumberError}</span>
                </div>
                <div class="input-box">
                    <span class="details">Password</span>
                    <input type="text" placeholder="Enter your password" name="password">
                    <span class="error-details">${passError}</span>
                </div>
                <div class="input-box">
                    <span class="details">Confirm Password</span>
                    <input type="text" placeholder="Confirm your password" name="confirmpassword">
                    <span class="error-details">${cpassError}</span>
                </div>
            </div>
            <div class="gender-details">
                <input type="radio" name="gender" id="dot-1" value="Male">
                <input type="radio" name="gender" id="dot-2" value="Female">
                <input type="radio" name="gender" id="dot-3" value="Prefer not to say">
                <span class="gender-title">Gender</span>
                <div class="category">
                    <label for="dot-1">
                        <span class="dot one"></span>
                        <span class="gender">Male</span>
                    </label>
                    <label for="dot-2">
                        <span class="dot two"></span>
                        <span class="gender">Female</span>
                    </label>
                    <label for="dot-3">
                        <span class="dot three"></span>
                        <span class="gender">Prefer not to say</span>
                    </label>
                </div>
            </div>
            <div class="button">
                <input type="submit" value="Register">
            </div>
        	<div class="login">
                <p>Already have an account?</p>
                <a href="Login.jsp">Login here</a>
            </div>
        </form>
    </div>
    
    <script src="https://unpkg.com/typed.js@2.1.0/dist/typed.umd.js"></script>

    <!-- Setup and start animation! -->
    <script>
        var typed = new Typed('#element', {
            strings: ['Registration'],
            typeSpeed: 50,
        });
    </script>

</body>
</html>