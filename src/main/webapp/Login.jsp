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

	
    <div class="container">

        <div class="title">Login</div>
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

			<span style="color : 'green';">${success}</span>

        </form>

    </div>

</body>
</html>