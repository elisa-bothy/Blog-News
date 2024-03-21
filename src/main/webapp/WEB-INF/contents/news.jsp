<%-- 
    Document   : adminNews
    Created on : 20 mars 2024, 09:52:53
    Author     : Valentina Sarais
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="container">
    <h1>${requestScope.news.title}</h1>
    <p>Auteur: ${requestScope.news.author.login}</p>
    <p>Date de création: ${requestScope.news.created}</p>
    <p class="message">${requestScope.news.content}</p>
    <div class="thumbs">
        <c:if test="${empty sessionScope.user}">
            <div class="thumbs-up">
                <a href=" <c:url value="/visitor/connect "/>">
                    <img src="<c:url value="/assets/photos/thumbs-up.png"/>" alt="thumbs-up"/>
                </a>
            </div>
            <div class="thumb-down">
                <a href=" <c:url value="/visitor/connect "/>">
                    <img src="<c:url value="/assets/photos/thumbs-down.png"/>" alt="thumbs-down"/>
                </a>
            </div>
        </c:if>
        <c:if test="${! empty sessionScope.user && sessionScope.user.id != 1}">
            <p>${requestScope.message}</p>
            <div class="thumbs-up">
                <a href=" <c:url value="/user/thumbsUp?id=${requestScope.news.id} "/>">
                    <img src="<c:url value="/assets/photos/thumbs-up.png"/>" alt="thumbs-up"/>
                </a>
            </div>
            <div class="thumb-down">
                <a href=" <c:url value="/user/thumbsDown?id=${requestScope.news.id} "/>">
                    <img src="<c:url value="/assets/photos/thumbs-down.png"/>" alt="thumbs-down"/>
                </a>
            </div>
        </c:if>
    </div>
    <h1>Commentaires</h1>
    <div class="error">${requestScope.errorMsg}</div>
    <div>
        <c:choose>
            <c:when test="${not empty requestScope.comments}">
                <c:forEach var="comment" items="${requestScope.comments}">
                    <div>
                        <p>${comment.content}</p>
                        <p>&Eacute;crit par ${comment.author.login} le ${comment.created}</p>
                        <c:if test="${comment.state != 2}">
                            <div class="signaler">
                                <a href="<c:url value="/visitor/signalComment"/>?commId=${comment.id}&id=${requestScope.news.id}">
                                    <img src="<c:url value="/assets/photos/icons8-attention-100.png"/>" alt="signaler"/>
                                    <span class= "button" >
                                        Signaler
                                    </span>
                                </a>
                            </div>
                        </c:if>
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
</div>

