<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Form</title>
<link rel="stylesheet" href="login.css">
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
        <form action="LoginServlet" method="post">

            <div class="user-details">
                <div class="input-box">
                    <span class="details">Username</span>
                    <input type="text" placeholder="Enter your username" name="username">
                    <span class="error-details" >${unameError}</span>
                </div>

                <div class="input-box">
                    <span class="details">Email</span>
                    <input type="text" placeholder="Enter your email-id" name="email">
                    <span class="error-details">${emailError}</span>
                </div>

                <div class="input-box">
                    <span class="details">Password</span>
                    <input type="text" placeholder="Enter your password" name="pass">
                    <span class="error-details">${passError}</span>
                </div>

            </div>
            <div class="button">
                <input type="submit" value="Login">
            </div>
            <div class="fpass">
                <p>Forgot Password?</p>
                <a href="ForgotPassword.jsp">Click here to reset</a>
            </div>

			<span style="color : 'green';">${success}</span>

        </form>

    </div>
    
    <script src="https://unpkg.com/typed.js@2.1.0/dist/typed.umd.js"></script>

    <!-- Setup and start animation! -->
    <script>
        var typed = new Typed('#element', {
            strings: ['Login'],
            typeSpeed: 50,
        });
    </script>

</body>
</html>