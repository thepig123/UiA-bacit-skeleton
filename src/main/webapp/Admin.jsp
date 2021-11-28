<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="styleadmin.css">
    <link rel="stylesheet" type="text/css" href="styleuser.css">
    <title>Title</title>
</head>
<body>

<ul id="NavBar">
    <a href="Admin.jsp"><img src="amv-logo.png" alt="amv logo" id="AMVLogo"></a>
    <li class="NavOption"><a href="DisplayToolServlet">RENT A TOOL</a></li>
    <li class="dropdown">
        <button class="dropbtn">ADMIN</button>
        <div class="dropdown-content">
            <a href="DeleteUserServlet">Behandle bruker</a>
            <a href="DisplayToolServlet">MANAGE TOOLS</a>
            <a href="#">RENTAL HISTORY</a>
            <a href="#">DOWNLOAD LEASE</a>
            <a href="fileUpload.jsp">UPLOAD LEASE</a>
        </div>
    </li>
    <li class="NavOption"><a href="index.jsp">LOG OUT</a></li>
</ul>

<div class="bottomPart">
    <h3> Trenger hjelp? Kontakt oss <u>her</u></h3>
</div>
</body>
</html>