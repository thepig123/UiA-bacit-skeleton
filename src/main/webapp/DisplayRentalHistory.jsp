<%@ page import="java.util.ArrayList"%>
<%@ page import="bacit.web.Servlet.Models.RentalModel" %>
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

<div class="col-sm-8"><h2>Liste over utstyr</h2></div>
<div class="col-sm-4">

</div>
</div>
</div>
<form method="post" action="DisplayRentHistoryServlet">
    <table id="customers">
        <thead>
        <tr>
            <th>VerktøyID</th>
            <th>Verktøy</th>
            <th>Skaderapport</th>
            <th>Lei fra dato</th>
            <th>Til dato</th>

        </tr>
        </thead>

            <% ArrayList<RentalModel> history = (ArrayList<RentalModel>) request.getAttribute("Rentals");
    for (RentalModel HistoryList : history) {
        out.println("<tr>" +
"        <td>"+HistoryList.getItem_ID()+ "</td>\n" +
//"        <td>"+HistoryList.getTool_name()+"</td>\n" +
"        <td>"+HistoryList.getDamage_report()+"</td>\n" +
"        <td>"+HistoryList.getRental_startDate()+"</td>\n" +
"        <td>"+HistoryList.getRental_endDate()+ "</td>\n" );
    }
%>
</form>
</body></html>

