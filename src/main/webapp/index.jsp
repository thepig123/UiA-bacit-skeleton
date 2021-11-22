<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>

    <title>Login</title>
    <link rel="stylesheet" href="style.css">
</head>

<body>
<img src="amv-logo.png" alt="amv logo" width="241" height="131" id="AMVLogo"> <br>
<div id="form">
    <h1 class="form"> Login </h1>
    <form class="form" action="CredentialCheckServlet" method="post">
        <label for="Email"> Email </label> <br>
        <input type="text" id="Email" name="User_Email" placeholder="Example@gmail.com"> <br>
        <label for="User_Password"> Password </label> <br>
        <input type="password" id="User_Password" name="User_Password" placeholder="Password"> <br>
        <button class="button" type="submit" value="Login"> Login</button>

    </form>
</div>
</body>
</html>