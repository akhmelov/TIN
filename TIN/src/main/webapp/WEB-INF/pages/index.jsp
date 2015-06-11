<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <jsp:include page="common/head.jsp"/>
    <title>Instytut Informatyki Wydziału Elektroniki i Technik Informacyjnych PW</title>

    <link href="<c:url value="/resources/css/index.css" />" rel="stylesheet">
</head>
<body>
<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
        <div class="item active">
            <img src="<c:url value="/resources/img/Warszawa_-_Politechnika.jpg" />" alt="Politechnika">

            <div class="carousel-caption">
                <div style="text-align:center; background-color:rgba(255,255,255,0.5);">
                    <br>

                    <p style="color:black; font-size:150%">Edytor XML dla Repozytorium Prac Dyplomowych
                        <br>Instytut Informatyki wydziału EiTI
                    </p>
                    <br>
                    <font color="black">
                        <table align="center" style="display: inline-table;">
                            <form:form class="navbar-form navbar-right" method="post" action="index"
                                       modelAttribute="singInForm" commandName="singInForm"
                                       enctype="multipart/form-data">
                                <div class="form-group">
                                    <form:input path="username"/><br>
                                    <form:input path="password" type="password"/><br>
                                    <input type="submit" value="Submit"/>
                                </div>
                            </form:form>
                        </table>
                    </font>
                </div>
            </div>
        </div>
        <div class="item">
            <img src="<c:url value="/resources/img/Warszawa_-_Politechnika.jpg" />" alt="Politechnika">

            <div class="carousel-caption">
                Politechnika Warszawska
            </div>
        </div>
    </div>
</div>
<jsp:include page="common/footer.jsp"/>
<script src="<c:url value="/resources/js/index.js" />"></script>
</body>
</html>