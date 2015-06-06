<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="common/head.jsp"/>
    <title>Instytut informatyki Wydział Elektroniki i Technik Informacyjnych</title>

    <link href="<c:url value="/resources/css/index.css" />" rel="stylesheet">
</head>
<body>
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li><a href="#">Instytut Informatyki</a></li>
                    <li><a href="#">Coś</a></li>
                </ul>
                <form:form class="navbar-form navbar-right" method="post" action="index" modelAttribute="singInForm" commandName="singInForm" enctype="multipart/form-data">
                    <div class="form-group">
                        <form:input path="username" />
                        <form:input path="password" type="password"/>
                    </div>
                    <input type="submit" value="Submit"/>
                </form:form>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>
    <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
            <li data-target="#carousel-example-generic" data-slide-to="2"></li>
        </ol>

        <!-- Wrapper for slides -->
        <div class="carousel-inner" role="listbox">
            <div class="item active">
                <img src="<c:url value="/resources/img/Warszawa_-_Politechnika.jpg" />" alt="Politechnika">
                <div class="carousel-caption">
                    Politechnika Warszawska
                </div>
            </div>
            <div class="item">
                <img src="<c:url value="/resources/img/Warszawa_-_Politechnika.jpg" />" alt="Politechnika">
                <div class="carousel-caption">
                    Politechnika Warszawska
                </div>
            </div>
        </div>

        <!-- Controls -->
        <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
    <jsp:include page="common/footer.jsp" />
    <script src="<c:url value="/resources/js/index.js" />"></script>
</body>
</html>