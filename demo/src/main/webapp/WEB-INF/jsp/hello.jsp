<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Prova</title>
</head>
<body>

<h1>${messaggi.get("message1")} <a href="/getAllCustomers"> --> </a></h1>
<h1>${messaggi.get("message2")} <a href="/getCustomerById"> --> </a></h1>
<h1>${messaggi.get("message3")} <a href="/updateCustomerById"> --> </a></h1>
<h1>${messaggi.get("message4")} <a href="/deleteCustomerById"> --> </a></h1>




</body>
</html>