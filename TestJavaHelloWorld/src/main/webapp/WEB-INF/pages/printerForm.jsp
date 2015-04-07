<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Sasha
  Date: 3/20/2015
  Time: 10:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Print</title>
</head>
<body>
    <h2>
        Printer form to print
    </h2>
    <form:form method="post" action="status" modelAttribute="printerForm" commandName="printerForm" enctype="multipart/form-data">
        <table>
            <tr>
                <td><label>Please select your printer: </label></td>
                <td>
                    <form:select path="printer">
                        <form:option value="" label="..." />
                        <form:options items="${listPrinters}" />
                    </form:select>
                </td>
            </tr>
            <tr>
                <td><label><form:label path="comment">Commente</form:label><label></td>
                <td><form:input path="comment" /></td>
            </tr>
            <tr>
                <td><label>Is black<label></td>
                <td><form:checkbox path="black" value="black"/></td>
            </tr>
            <tr>
                <td><label>Is double page<label></td>
                <td><form:checkbox path="doublePage" value="${printerForm.doublePage}"/></td>
            </tr>
            <tr>
                <td><label>File: <label></td>
                <td><form:input path="file" type="file"/></td>
            </tr>
            <td colspan="2">
                <input type="submit" value="Submit"/>
            </td>
        </table>
    </form:form>
</body>
</html>
