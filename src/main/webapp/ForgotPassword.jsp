<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="forgotpassword.css">
<title>Forgot Password</title>
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

        <div class="title">
            <span id="element"></span>
        </div>
        <form action="ForgotPasswordServlet" method="post">

            <div class="user-details">
            
            	<div class="input-box">
                    <span class="details">Username</span>
                    <input type="text" placeholder="Enter your Username" name="uname">
                    <span class="error-details">${unameError}</span>
                </div>
            
                <div class="input-box">
                    <span class="details">New Password</span>
                    <input type="text" placeholder="Enter your new password" name="newpass">
                    <span class="error-details">${newpassError}</span>
                </div>

                <div class="input-box">
                    <span class="details">Confirm new password</span>
                    <input type="text" placeholder="Confirm your new password" name="confirmnewpass">
                    <span class="error-details">${cnewpassError}</span>
                </div>
            </div>
            <div class="button">
                <input type="submit" value="Change Password">
            </div>
            
            <span style="coolro :' red';">${errorMSG}</span>
            
        </form>

    </div>
    
    <script src="https://unpkg.com/typed.js@2.1.0/dist/typed.umd.js"></script>

    <!-- Setup and start animation! -->
    <script>
        var typed = new Typed('#element', {
            strings: ['Change Password'],
            typeSpeed: 50,
        });
    </script>

</body>
</html>