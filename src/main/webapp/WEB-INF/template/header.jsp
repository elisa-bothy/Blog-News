<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<header>
    <div class="logo">
        <a href="<c:url value="/visitor/index"/>">
            <div>
                <img src="<c:url value="/assets/photos/news.png"/>" alt="alt"/>
            </div>
        </a>
    </div>
    <ul>
        <c:choose>
            <c:when test="${empty sessionScope.user}">
                <a href="<c:url value="/visitor/connect" />"><li>Connexion</li></a>
                <a href="<c:url value="/visitor/signUp" />"><li>Inscription</li></a>
            </c:when>
            <c:when test="${sessionScope.user.id == 1}">
                <a href="<c:url value="/admin/usersList" />"><li>Gestion Utilisateurs</li></a>
                <a href="<c:url value="/admin/commentsList" />"><li>Gestion Commentaire</li></a>
                <a href="<c:url value="/admin/newsList" />"><li>Gestion News</li></a>
                <a href="<c:url value="/user/profile" />"><li>Profil</li></a>
                <a href="<c:url value="/user/logOut" />"><li>Déconnexion</li></a>
            </c:when>
                <c:otherwise>
                    <a href="<c:url value="/user/profile" />"><li>Profil</li></a>
                    <a href="<c:url value="/user/logOut" />"><li>Déconnexion</li></a>
                </c:otherwise>
        </c:choose>
    </ul>
</header>
