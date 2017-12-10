<%@ page import="com.sda.twitter.servlets.PublishServlet" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="utf-8" %>

<html>
<!-- add tweet -->
<head>
    <title>SDA PUBLISH</title>
</head>
<body>

<%
    String error = request.getParameter("error");
    if (error != null && "".equals(error)) {
        out.print("No user or message input! Please enter fields correctly.");
    }

    String author = "";
    for (Cookie cookie : request.getCookies()) {
        if (PublishServlet.AUTHOR_COOKIE.equals(cookie.getName())) {
            author = cookie.getValue();
        }
    }
%>

<form action="/publish" method="post">
    <fieldset>
        <ul>
            <li>Author: <input name="author" type="text" value="<%= author %>"
                               style="width:300px; height:50px; margin-left:30px"/>
            </li>
            <li>Message: <textarea name="message" type="text"
                                   style="width:300px; height:50px; margin-left:30px"></textarea></li>
        </ul>
        <input type="submit" name="Submit" value="Publish" method="post">
    </fieldset>
</form>

</body>
</html>