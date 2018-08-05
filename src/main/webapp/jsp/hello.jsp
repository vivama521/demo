<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="../css/style.css"/>
        <link rel="script" href="https://code.jquery.com/jquery-3.3.1.js"/>
        <title>Prova</title>
    </head>
    <body>
        <%--<h1>${messaggi.get("message1")} <a href="/getAllCustomers"> --> </a></h1>
        <h1>${messaggi.get("message2")} <a href="/getCustomerById"> --> </a></h1>
        <h1>${messaggi.get("message3")} <a href="/updateCustomerById"> --> </a></h1>
        <h1>${messaggi.get("message4")} <a href="/deleteCustomerById"> --> </a></h1>
        <h1>${messaggi.get("message5")} <a href="/jspConForm"> --> </a></h1>--%>

        <div class="container-fluid">
            <div class="ml-1 mt-3">
                <div class="list-group">
                    <c:forEach items="${messaggi.keySet()}" var="key">
                        <c:set var="cur" value="${messaggi.get(key)}"/>
                        <jsp:useBean id="cur" type="com.gestionebiliardi.beanutil.ControllerUrlRepo"/>
                        <a href="${cur.url}" class="list-group-item col-4 alink">
                            <c:out value="${cur.message}"/>
                        </a>
                    </c:forEach>
                </div>
            </div>
        </div>
    </body>
</html>