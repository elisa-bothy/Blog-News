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
        <c:forEach var="comment" items="${requestScope.comments}">
            <c:if test="${requestScope.comment.id} == ${requestScope.news.id}">
                <comment>
                    <div>${comment.content}</div>
                    <div class="under">&Eacute;crit par ${comment.author.login} le ${comment.created}</div>
                    <div class="more"><a href="<c:url value="comment?id=${comment.id}"/>">Signaler</a></div>
                </comment>
            </c:if>
        </c:forEach>
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

