<%-- 
    Document   : adminUser
    Created on : 20 mars 2024, 09:53:25
    Author     : Guillaume Rostagnat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container" id="container">
    <table>
        <thead>
            <tr>
                <th>Id de l'utilisateur</th>
                <th>Identifiant de l'utilisateur</th>
                <th>Mot de Passe de l'utilisateur</th>
                <th>Profil </th>
                <th>Supprimer l'utilisateur</th>
                <th>Désactiver l'utilisateur</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${requestScope.users}">
            <tr>
                <c:if test="${user.id !=1}">
                    <td>${user.id}</td>
                    <td><c:out value="${user.login}"/></td>
                    <td><c:out value="${user.password}"/></td>
                    <td> <c:choose><c:when test="${user.active}">
                                Activé
                            </c:when><c:otherwise>
                                Desactivé
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td><a href="<c:url value="/admin/eraseUser"/>?userId=${user.id}"><span  class="button">Supprimer</span></a></td>
                    <c:set var="textoBotao" value="${user.active ? 'Desactiver' : 'Activer'}" />
                    <td><a href="<c:url value="/admin/admin${user.active ? 'Desactive' : 'Active'}User"/>?id=${user.id}">
                            <span class="button">${textoBotao}</span></td>
                </c:if> 
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

