<%-- 
    Document   : adminComm
    Created on : 20 mars 2024, 09:53:17
    Author     : Guillaume Rostagnat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container" id="container">
    <table>
        <thead>
            <tr>
                <th>ID du commentaire</th>
                <th>Auteur du commentaire</th>
                <th>Date de création du commentaire</th>
                <th>Contenu du commentaire</th>
                <th>Supprimer le commentaire</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="comm" items="${requestScope.comms}">
            <tr>
                <td>${comm.id}</td>
                <td><c:out value="${comm.author.login}"/></td>
                <td>${comm.created}</td>
                <td><c:out value="${comm.content}"/></td>
                <td><a href="<c:url value="/admin/deleteComm"/>?commId=${comm.id}"><span  class="button">Supprimer</span></a></td>  
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
