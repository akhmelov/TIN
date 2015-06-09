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
    <title>Spring MVC Form Handling</title>

    <link href="<c:url value="/resources/css/admin.css" />" rel="stylesheet">
</head>
<body>
    <div id="workspace">
        <jsp:include page="common/headerPanel.jsp" />
        <h2>Submitted Student Information</h2>
        <!-- Table -->
        <table class="table table-striped">
            <tr>
                <th>Mail</th>
                <th>Surname</th>
                <th>Name</th>
                <th>Password</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="listVar" items="${users}" varStatus="loop">
                <tr>
                    <td>
                        <c:out value="${listVar.mail}"/>
                    </td>
                    <td><c:out value="${listVar.surname}"/></td>
                    <td><c:out value="${listVar.name}"/></td>
                    <td><c:out value="${listVar.password}"/></td>
                    <td>
                        <%--<span id="<c:out value="${listVar.id}"/>" class="glyphicon glyphicon-pencil" onclick="editUser(${listVar.id})" aria-hidden="true"></span>--%>
                    </td>
                    <td>
                        <span id="<c:out value="${listVar.id}"/>" class="glyphicon glyphicon-trash" onclick="deleteBasket(${listVar.id})" aria-hidden="true"></span>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <button type="button" id="add" class="btn btn-success">Dodaj</button>
    </div>
    <!-- Modal -->
    <div hidden="hidden">
        <div id="dialog" title="Dodaj nowego uzytkownika">
            <form id="userForm" class="navbar-form navbar-right userAddForm" method="post">
                <div class="row">
                    <div class="col-lg-6">
                        <div class="form-group">
                            <div class="input-group input-group-sm">
                                <input type="text" name="mail" id="mail" placeholder="Mail">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-6">
                        <div class="form-group">
                            <div class="input-group input-group-sm">
                                <input type="text" name="name" id="name" placeholder="Imie">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-6">
                        <div class="form-group">
                            <div class="input-group input-group-sm">
                                <input type="text" name="surname" id="surname" placeholder="Nazwisko">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-6">
                        <div class="form-group">
                            <div class="input-group input-group-sm">
                                <input type="text" name="password" id="password" placeholder="password">
                            </div>
                        </div>
                    </div>
                </div>
                <br/>
                <button type="button" id="userForm" class="btn btn-success">Dodaj</button>
            </form>
        </div>
    </div>
    <jsp:include page="common/footer.jsp" />
    <script src="<c:url value="/resources/js/admin.js" />"></script>
</body>
</html>
