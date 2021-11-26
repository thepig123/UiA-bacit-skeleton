<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<ul id="NavBar">
    <li class="NavOption"><a href="DisplayRentHistoryServlet">RentalHistory</a></li>
    <li class="NavOption"><a href="index.jsp">Log out</a></li>
</ul>
<img src="amv-logo.png" alt="amv logo" width="241" height="131" id="AMVLogo"> <br>
<ul id="Options">
    <li class="NavOption"><a href="${pageContext.request.contextPath}/fileDownload">Download lease</a></li>
    <li class="NavOption"><a href="fileUpload">Upload lease</a> </li>
    <li class="NavOption"><a href="AddUserServlet">Add a user</a> </li>
    <li class="NavOption"><a href="AddToolsServlet">Add a tool</a> </li>

</ul>
</body>
</html>

