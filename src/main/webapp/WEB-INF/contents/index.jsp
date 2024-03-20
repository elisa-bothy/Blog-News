<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container" id="container">
    <div id="articles">
        <c:if test="${! empty sessionScope.user}">
            <a href="<c:url value="/user/createNews"/>"><span  class="button">Créer un Nouvelle News</span></a>
        </c:if>
        <div class="bestNews">
            <c:forEach var="bNews" items="${requestScope.bestNews}">
                <article class="bNews">
                    <img src="<c:url value="/assets/photos/icons8-fake-news-64(1).png"/>" alt="L'image de l'article"/>
                    <h3>${bNews.subject}</h3>
                    <div>&Eacute;crit par ${bNews.author.login} le ${bNews.created}</div>
                    <div class="news-content">${bNews.content}</div>
                    <div>
                        <a href=" <c:url value="article?id=${bNews.id} "/>" >
                            <img src="<c:url value="/assets/photos/plus-jaune.png"/>" alt="En savoir plus"/>
                        </a>
                    </div>
                    <div class="score">
                        ${bNews.score}
                        <img src="<c:url value="/assets/photos/thumbs-up.png"/>" alt="Pouce en l'air"/>
                    </div>
                </article>
            </c:forEach>
        </div>
        <div class="allNews">  
            <c:forEach var="news" items="${requestScope.allNews}">
                <article class="news">
                    <img src="<c:url value="/assets/photos/icons8-fake-news-64.png"/>" alt="L'image de l'article"/>
                    <h3>${news.subject}</h3>
                    <div>&Eacute;crit par ${news.author.login} le ${news.created}</div>
                    <div class="news-content">${news.content}</div>
                    <div>
                        <a href=" <c:url value="/visitor/news?id=${news.id} "/>" >
                            <img src="<c:url value="/assets/photos/plus-vert.png"/>" alt="En savoir plus"/>
                        </a>
                    </div>
                    <div class="score">
                        ${news.score}
                        <img src="<c:url value="/assets/photos/thumbs-up.png"/>" alt="Pouce en l'air"/>
                    </div>
                </article>
            </c:forEach>
        </div>  
    </div>
</div>
