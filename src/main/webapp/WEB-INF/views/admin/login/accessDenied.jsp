<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false" %>

<html>
<head>
    <title>Access Denied</title>
</head>
<body>
    <h3>Access Denied To Admin Panel</h3>
    ${msg}
    <a href="${pageContext.request.contextPath}/admin-panel">Back</a>
</body>
</html>