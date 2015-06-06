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
                <th>Index</th>
                <th>Mail</th>
                <th>Surname</th>
                <th>Name</th>
                <th>Position</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="listVar" items="${users}" varStatus="loop">
                <tr>
                    <td><c:out value="${listVar.id}"/></td>
                    <td>
                        <a href="basket?idBasket=${listVar.id}"><c:out value="${listVar.mail}"/></a>
                    </td>
                    <td><c:out value="${listVar.surname}"/></td>
                    <td><c:out value="${listVar.name}"/></td>
                    <td><c:out value=""/>test</td>
                    <td>
                        <span id="<c:out value="${listVar.id}"/>" class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                    </td>
                    <td>
                        <span id="<c:out value="${listVar.id}"/>" class="glyphicon glyphicon-trash" onclick="deleteBasket(${listVar.id})" aria-hidden="true"></span>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <button type="button" id="add" class="btn btn-success">Add</button>
    </div>


    <!-- Trigger the modal with a button -->
    <button type="button" id="openModal" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Open Modal</button>

    <!-- Modal -->
    <div id="myModal" class="modal fade" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Modal Header</h4>
                </div>
                <div class="modal-body">
                    <p>Some text in the modal.</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>

        </div>
    </div>
    <jsp:include page="common/footer.jsp" />
    <script src="<c:url value="/resources/js/admin.js" />"></script>
</body>
</html>
