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

	<div class="container">

        <div class="title">Change Password</div>
        <form action="ForgotPasswordServlet" method="post">

            <div class="user-details">
            
            	<div class="input-box">
                    <span class="details">Username</span>
                    <input type="text" placeholder="Enter your Username" name="uname">
                </div>
            
                <div class="input-box">
                    <span class="details">New Password</span>
                    <input type="text" placeholder="Enter your new password" name="newpass">
                </div>

                <div class="input-box">
                    <span class="details">Confirm new password</span>
                    <input type="text" placeholder="Confirm your new password" name="confirmnewpass">
                </div>
            </div>
            <div class="button">
                <input type="submit" value="Change Password">
            </div>
            
            <span>${passError}</span>

        </form>

    </div>

</body>
</html>