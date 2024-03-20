<%-- 
    Document   : adminNews
    Created on : 20 mars 2024, 09:52:53
    Author     : Guillaume Rostagnat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container" id="container">
    <table>
        <thead>
            <tr>
                <th>ID de la news</th>
                <th>Titre de la news</th>
                <th>Auteur de la news</th>
                <th>Date de création de la news</th>
                <th>Contenu de la news</th>
                <th>Supprimer la news</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="news" items="${requestScope.allNews}">
            <tr>
                <td>${news.id}</td>
                <td><c:out value="${news.title}"/></td>
                <td><c:out value="${news.author.login}"/></td>
                <td>${news.created}</td>
                <td><c:out value="${news.content}"/></td>
                <td><a href="<c:url value="/admin/eraseArticle"/>?articleId=${news.id}"><span  class="button">Supprimer</span></a></td>  
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

