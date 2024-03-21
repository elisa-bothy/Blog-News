<%-- 
    Document   : adminNews
    Created on : 20 mars 2024, 09:52:53
    Author     : Valentina Sarais
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<main>
    <h1>${requestScope.news.title}</h1>
    <p>Auteur: ${requestScope.news.author.login}</p>
    <p>Date de création: ${requestScope.news.created}</p>
    <p>${requestScope.news.content}</p>
    <h1>Commentaires</h1>
    <div class="error">${requestScope.errorMsg}</div>
    <div>
        <c:choose>
            <c:when test="${not empty requestScope.comments}">
                <c:forEach var="comment" items="${requestScope.comments}">
                    <div>
                        <p>${comment.content}</p>
                        <p>&Eacute;crit par ${comment.author.login} le ${comment.created}</p>
                        <p><a href="<c:url value="/visitor/signalComment"/>?commId=${comment.id}&id=${requestScope.news.id}"><img src="<c:url value="/assets/photos/icons8-attention-100.png"/>" alt="alt"/></a></p>
                    </div>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <p>Aucun commentaire disponible pour cet article.</p>
            </c:otherwise>
        </c:choose>        
    </div>
    <c:if test="${! empty sessionScope.user}">
        <form action="<c:url value="/visitor/news?id=${requestScope.news.id}" />" method="post">
            <fieldset>
                <legend>Ecris ton commentaire ici :</legend>
                <div>
                    <textarea id="content" name="content" type="content">
                        <c:out value="${requestScope.comment.content}" escapeXml="true" />
                    </textarea>
                </div>
            </fieldset>
            <div class="message">${requestScope.messages.newComment}</div>
            <div class="buttons">
                <input type="submit" value="Envoyer">
                <input type="reset" value="Annuler">
            </div>
        </form>
    </c:if>
</main>

