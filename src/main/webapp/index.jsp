<%@ page import="com.sda.twitter.model.MyTweet" %>
<%@ page import="com.sda.twitter.service.MyTwitterService" %>
<%@ page contentType="text/html" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<html>
<!-- list tweets -->
<head>
    <title>SDA INDEX</title>
</head>
<body>

<p>
    <a href="publish.jsp">Publish tweet</a>
</p>

<%!
    MyTwitterService service = MyTwitterService.getInstance();
%>

<table border="2">
    <tr>
        <td width="100px">Author</td>
        <td width="300px">Date</td>
        <td width="400px">Message</td>
    </tr>
    <%
        for (MyTweet tweet : service.getMyTweetList()) {
            out.print("</tr>");
            out.print("<td>" + tweet.getAuthor() + "</td>");
            out.print("<td>" + tweet.getTimestamps() + "</td>");
            out.print("<td>" + tweet.getTweet() + "</td>");
            out.print("</tr>");
        }
    %>

</table>

</body>
</html>