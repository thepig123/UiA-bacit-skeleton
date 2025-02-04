<%@ page import="java.util.ArrayList"%>
<%@ page import="Models.ToolsModel"%>
<%@ page import="bacit.web.Servlet.Models.RentalModel" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="table.css">
    <link rel="stylesheet" href="styleadmin.css">
    <link rel="stylesheet" href="styleuser.css">
    <title>AMV utlån</title>

</head>
<body>
<div class="col-sm-8"><h2>Liste over utstyr</h2></div>
<div class="col-sm-4">

</div>
<form method="post" action="RentToolServlet">
    <table id="customers">
        <thead>
        <tr>
            <th>Verktøy</th>
            <th>Tilgjengelighet</th>
            <th>Pris første døgn</th>
            <th>Pris ytterligere døgn</th>
            <th>Informasjon</th>
            <th>Verktøytype</th>

        </tr>
        </thead>

            <% ArrayList<ToolsModel> tools = (ArrayList<ToolsModel>) request.getAttribute("Tools");
    for (ToolsModel ToolList : tools) {
        out.println("<tr>" +
"        <td>"+ToolList.getTool_name()+"</td>\n" +
"        <td>"+"Ledig"+"</td>\n" +
"        <td>"+ToolList.getPrice_firstDay()+"</td>\n" +
"        <td>"+ToolList.getPrice_followingDays()+ "</td>\n" +
"        <td>"+ToolList.getTool_info()+"</td>\n" +
"        <td>"+ToolList.getTool_type()+"</td>\n" +
"        <input type=\"hidden\"name=\"Item_ID\"value= "+ToolList.getItem_ID()+">\n" +
"        <td><input type=\"date\"name=\"Rental_startDate\"></td>\n" +
"        <td><input type=\"date\"name=\"Rental_endDate\"></td>\n" +
"        <td><button type = 'submit'> Rent </button></td>\n" + "</td></tr>");
    }
%>
</form>
</body></html>