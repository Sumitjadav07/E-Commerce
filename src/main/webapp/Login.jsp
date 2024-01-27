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
                </div>

                <div class="input-box">
                    <span class="details">Mobile Number</span>
                    <input type="text" placeholder="Enter your number" name="mobile">
                </div>

                <div class="input-box">
                    <span class="details">Password</span>
                    <input type="text" placeholder="Enter your password" name="pass">
                </div>


            </div>
            <div class="button">
                <input type="submit" value="Login">
            </div>

        </form>

    </div>

</body>
</html>