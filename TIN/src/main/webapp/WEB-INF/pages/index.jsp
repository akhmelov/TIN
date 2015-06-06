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
    <section class="rw-wrapper">
        <h2 class="rw-sentence">
            <span>Real poetry is like</span>
            <span>creating</span>
            <div class="rw-words rw-words-1">
                <span>breathtaking moments</span>
                <span>lovely sounds</span>
                <span>incredible magic</span>
                <span>unseen experiences</span>
                <span>happy feelings</span>
                <span>beautiful butterflies</span>
            </div>
            <br />
            <span>with a silent touch of</span>
            <div class="rw-words rw-words-2">
                <span>sugar</span>
                <span>spice</span>
                <span>colors</span>
                <span>happiness</span>
                <span>wonder</span>
                <span>happiness</span>
            </div>
        </h2>
    </section>
    <jsp:include page="common/footer.jsp" />
    <script src="<c:url value="/resources/js/index.js" />"></script>
</body>
</html>