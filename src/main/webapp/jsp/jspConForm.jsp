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

<!DOCTYPE html>


<html>
<head>
    <title>Aggiungi un cristiano alla lista</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css"/>
</head>
<body>
    <%--<div class="container-fluid">
        <fieldset class="mb-3">
        <legend>Dati del soggetto</legend>
            <form:form action="/elaboraInfoForm" method="POST">
                <div class="input-group mb-3 justify-content-md-center">
                    <div class="input-group-prepend">
                        <span class="input-group-text">Person</span>
                    </div>
                    &lt;%&ndash;<form:label cssClass="label" path="name" for="nome">Nome</form:label>&ndash;%&gt;
                    <form:input placeholder="Nome" cssClass="form-control col-md-3" path="name" id="nome"/>

                    &lt;%&ndash;<form:label path="secondName" for="cognome">Cognome</form:label>&ndash;%&gt;
                    <form:input placeholder="Cognome" cssClass="form-control col-md-3" type="text" path="secondName" id="cognome"/>
                </div>
                <div class="justify-content-center">
                    <form:button class="btn btn-primary" type="submit">Inserisci</form:button>
                </div>
            </form:form>
        </fieldset>
    </div>--%>


    <div class="container">
        <div class="row justify-content-center">
            <div class="col-12 col-md-8 col-lg-10 pb-5 mt-5">
                <form:form action="/elaboraInfoForm" method="POST" id="insertPerson">
                    <div class="card border-primary rounded-0">
                        <div class="card-header p-0">
                            <div class="bg-info text-white text-center py-2">
                                <h3><i class="fa fa-envelope"></i>Dati del soggetto</h3>
                            </div>
                        </div>
                        <div class="card-body p-3">
                            <div class="form-group">
                                <div class="input-group">
                                    <form:input placeholder="Nome" cssClass="form-control" path="name" id="nome" modelAttribute="insertPerson"/>
                                    <form:input placeholder="Cognome" cssClass="form-control" path="secondName" id="cognome"/>
                                    <div class="input-group-append">
                                        <form:button class="btn btn-info" type="submit">Inserisci</form:button>
                                    </div>
                                    <%--<div class="input-group mt-3 invalid-feedback">
                                        <div class="input-group">
                                            <form:errors path="name"/>
                                        </div>
                                        <div class="input-group">
                                            <form:errors path="secondName"/>
                                        </div>
                                    </div>--%>
                                </div>
                                <div class="input-group mt-3 invalid-feedback">
                                    <c:forEach items="${errors.getAllErrors()}" var="error">
                                        <div class="input-group">
                                            <c:out value="${error.getDefaultMessage()}"/>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</body>
</html>