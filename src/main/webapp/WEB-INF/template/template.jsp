<%-- 
    Document   : template
    Created on : 18 mars 2024, 15:36:01
    Author     : Elisa Bothy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="<c:url value="/assets/photos/icons8-news-64.png" />">
        <link rel="stylesheet" href="<c:url value="/assets/css/style.css" />">
        <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
        <title>${param.title}</title>
    </head>
    <body>
        <jsp:include page="/WEB-INF/template/header.jsp" />
        <main>
            <jsp:include page="/WEB-INF/contents/${param.content}.jsp" />
        </main>
        <jsp:include page="/WEB-INF/template/footer.jsp" />
        <script src="<c:url value="" />"></script> 
    </body>
</html>

