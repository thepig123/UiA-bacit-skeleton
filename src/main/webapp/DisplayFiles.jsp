<%@ page import="bacit.web.Servlet.Models.FileModel" %>
<%@ page import="bacit.web.Servlet.DAO.FileDAO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Arrays" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>AMV utlån</title>
    <link rel="stylesheet" href="table.css">
</head>
<body>

<div class="col-sm-8"><h2>Liste over dokumenter</h2></div>
<div class="col-sm-4">

</div>
</div>
</div>
<table id="customers">
    <thead>
    <tr>
        <th>Name</th>
        <th>Content</th>
        <th>ContentType</th>


    </tr>
    </thead>

        <% ArrayList<FileModel> tempFiles = (ArrayList<FileModel>) request.getAttribute("Files");
    for (FileModel Files : tempFiles) {
        out.println("<tr>" +
"        <td>"+ Files.getName()+"</td>\n" +
"        <td>"+ Arrays.toString(Files.getContents())+"</td>\n" +
"        <td>"+Files.getContentType()+"</td>\n" + "</td></tr>");
    }
%>

</body></html>