<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>Affichage news en entier + form commentaire</h2>
<main>
    <h1>${requestScope.news.title}</h1>
    <p>Auteur: ${requestScope.news.author.login}</p>
    <p>Date de création: ${requestScope.article.created}</p>
    <p>${requestScope.article.content}</p>
    <h1>Commentaires</h1>
    <div class="error">${requestScope.errorMsg}</div>
    <div>
        <c:forEach var="comment" items="${requestScope.comments}">
            <comment>
                <div>${comment.content}</div>
                <div class="under">&Eacute;crit par ${comment.author.login} le ${comment.created}</div>
            </comment>
        </c:forEach>
    </div>
    <form action="<c:url value="/visitor/news" />" method="post">
        <fieldset>
            <legend>Ecris ton commentaire ici :</legend>
            <div>
                <label for="content">Content</label>
                <textarea id="content" name="content" type="content">
                    <c:out value="${requestScope.comment.content}" escapeXml="true" />
                </textarea>
                <p>Auteur: ${requestScope.comment.author.login}</p>
                <p>Date de création: ${requestScope.comment.created}</p>
            </div>
        </fieldset>
        <div class="buttons">
            <input type="submit" value="Envoyer">
            <input type="reset" value="Annuler">
        </div>
    </form>
</main>
