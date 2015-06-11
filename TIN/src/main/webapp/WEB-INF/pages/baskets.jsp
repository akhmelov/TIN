<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: Sasha
  Date: 3/19/2015
  Time: 10:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
    <head>
        <jsp:include page="common/head.jsp"/>
        <title>Zbiory prac</title>

        <link href="<c:url value="/resources/css/baskets.css" />" rel="stylesheet">
        <script src="<c:url value="/resources/js/baskets.js" />"></script>
    </head>
    <body>
        <jsp:include page="common/headerPanel.jsp" />
        <button value="changePassword" onclick="changePassword()">Zmień hasło</button>
        <div id="workspace">
            <h2>Zbiory prac dyplomowych</h2>
            <!-- Table -->
            <table class="table table-striped">
                <tr>
                    <th>Nazwa</th>
                    <th>Data utworzenia</th>
                    <th></th>
                    <th></th>
                </tr>
                <c:forEach var="listVar" items="${baskets}" varStatus="loop">
                    <tr>
                        <td>
                            <a href="basket?idBasket=${listVar.id}"><c:out value="${listVar.name}"/></a>
                        </td>
                        <td><c:out value="${listVar.dateCreate}"/></td>
                        <td>
                            <span id="<c:out value="${listVar.id}"/>" class="glyphicon glyphicon-pencil" onclick="editBasket(${listVar.id})" aria-hidden="true"></span>
                        </td>
                        <td>
                            <span id="<c:out value="${listVar.id}"/>" class="glyphicon glyphicon-trash" onclick="deleteBasket(${listVar.id})" aria-hidden="true"></span>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <button type="button" id="add" class="btn btn-success">Dodaj</button>
        </div>
    </body>
</html>
