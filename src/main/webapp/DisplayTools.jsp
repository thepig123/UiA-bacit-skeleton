<%@ page import="java.util.ArrayList" %>
<%@ page import="Models.ToolsModel" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>AMV utlån</title>
</head>
<body>

<div class="col-sm-8"><h2>Liste over utstyr</h2></div>
<div class="col-sm-4">

</div>
</div>
</div>
<table class="table table-bordered">
    <thead>
    <tr>
        <th>Availability</th>
        <th>Tool name</th>
        <th>Price firstDay</th>
        <th>Price followingDays</th>
        <th>Tool info</th>
        <th>Tool type</th>

    </tr>
    </thead>

        <% ArrayList<ToolsModel> tempTools = (ArrayList<ToolsModel>) request.getAttribute("Tools");
    for (ToolsModel Tool : tempTools) {
        out.println("<tr>" +
"        <td>"+ Tool.isAvailability()+"</td>\n" +
"        <td>"+Tool.getTool_name()+"</td>\n" +
"        <td>"+Tool.getPrice_firstDay()+"</td>\n" +
"        <td>"+Tool.getPrice_followingDays()+ "</td>\n" +
"        <td>"+Tool.getTool_info()+"</td>\n" +
"        <td>"+Tool.getTool_type()+"</td>\n" + "</td></tr>");
    }
%>

</body></html>