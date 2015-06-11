<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN">
<html>
	<head>

        <link href="<c:url value="/resources/css/maket.css" />" rel="stylesheet">
        <script src="<c:url value="/resources/js/maket.js" />"></script>

	  <title>Moja strona</title>
	</head>
	<body>
                <div style="position: relative">
                <div type="hidden" style="display: none;"> <!-- work space js -->
                    <jsp:include page="tags/record.jsp"/>
                </div>
                <div id="studentsForm">
                </div>
        </div>
	</body>
</html>