<%--
  Created by IntelliJ IDEA.
  User: sviluppo
  Date: 03/08/18
  Time: 11.48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix = "form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
    <title>Aggiungi un cristiano alla lista</title>
</head>
<body>
    <fieldset>
        <legend>Dati del soggetto</legend>
        <form:form action="/elaboraInfoForm" method="POST">

            <form:label path="name" for="nome">Nome</form:label>
            <form:input path="name" id="nome"/>

            <form:label path="secondName" for="cognome">Cognome</form:label>
            <form:input type="text" path="secondName" id="cognome"/>

            <form:button type="submit" name="Inserisci" />
        </form:form>
    </fieldset>
</body>
</html>
