<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="utf-8" %>

<html>
<head>
    <title>LOGIN</title>
    <link rel="stylesheet" href="style.css"/>
</head>

<body>

<form>
    <div class="container">
        <label><b>Username</b></label>
        <input type="text" placeholder="Enter Username" name="nick">

        <label><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="password">

        <button type="submit"><a href="message.jsp">Login</a></button>
        <input type="checkbox" checked="checked"> Remember me
    </div>

</form>

</body>
</html>