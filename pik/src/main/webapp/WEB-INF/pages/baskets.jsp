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
    </head>
    <body>
        <div id="workspace">
            <h2>Submitted Student Information</h2>
            <!-- Table -->
            <table class="table table-striped">
                <tr>
                    <th>Index</th>
                    <th>Name</th>
                    <th>Date Create</th>
                    <th>Date Edit</th>
                    <th>Position</th>
                    <th></th>
                    <th></th>
                </tr>
                <tr>
                    <td>1</td>
                    <td>Nazwa</td>
                    <td>2015-04-10 21:48</td>
                    <td>2015-04-10 21:48</td>
                    <td>5</td>
                    <td>
                        <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                    </td>
                    <td>
                        <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                    </td>
                </tr>
            </table>
        </div>
    </body>
</html>
