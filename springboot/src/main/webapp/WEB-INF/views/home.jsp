<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>welcome</title>
    <link href="${ctx}/static/skynet.css" type="text/css" rel="stylesheet" />
</head>

<body>
<!-- BEGIN CONTENT -->
<div class="page-content-wrapper">
    <div class="page-content">
     Hello <c:out value="${name}" default="Spring Boot"></c:out>
     "${ctx}"
     <span> ${user.userName} </span>
    </div>
    <c:forEach var="a" items="${a}">
    
    </c:forEach>
</div>
<!-- END CONTENT -->

<!-- BEGIN PAGE LEVEL PLUGINS -->
<!-- END PAGE LEVEL PLUGINS -->
</body>
</html>
