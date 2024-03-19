<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container" id="container">
    <div id="articles">
        <c:if test="${user != null}">
            <a href="<c:url value="/user/createNews"/>"><span  class="button">Créer un Nouvelle News</span></a>
        </c:if>
        <c:forEach var="bNews" items="${requestScope.bestNews}">
            <article class="bestNews">
                <h3>${bNews.subject}</h3>
                <div>&Eacute;crit par ${bNews.author.login} le ${bNews.created}</div>
                <div class="news-content">${bNews.content}</div>
                <div>
                    <a href=" <c:url value="article?id=${bNews.id} "/>" >
                        <img src="<c:url value="/assets/photos/plus-jaune.png"/>" alt="En savoir plus"/>
                    </a>
                </div>
                <c:if test="${bNews.id} == ${requestScope.vote.id_user}">
                    <div class="score-">
                        ${requestScope.vote.score}
                        <<img src="<c:url value="/assets/photos/thumbs-up.png"/>" alt="Pouce en l'air"/>
                    </div>
                </c:if>
            </article>
        </c:forEach>
        <c:forEach var="news" items="${requestScope.allNews}">
            <article class="news">
                <h3>${news.subject}</h3>
                <div>&Eacute;crit par ${news.author.login} le ${news.created}</div>
                <div class="news-content">${news.content}</div>
                <div>
                    <a href=" <c:url value="article?id=${news.id} "/>" >
                        <img src="<c:url value="/assets/photos/plus-jaune.png"/>" alt="En savoir plus"/>
                    </a>
                </div>
                <c:if test="${news.id} == ${requestScope.vote.id_user}">
                    <div class="score-">
                        ${requestScope.vote.score}
                        <<img src="<c:url value="/assets/photos/thumbs-up.png"/>" alt="Pouce en l'air"/>
                    </div>
                </c:if>
            </article>
        </c:forEach>
    </div>
</div>