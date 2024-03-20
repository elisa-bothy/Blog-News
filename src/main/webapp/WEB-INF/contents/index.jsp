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
                    <div class="img-news">
                        <img src="<c:url value="/assets/photos/icons8-fake-news-64(1).png"/>" alt="L'image de l'article"/>
                    </div>
                    <div class="text-news">
                        <h3>${bNews.title}</h3>
                        <div>&Eacute;crit par ${bNews.author.login} le ${bNews.created}</div>
                        <div class="text-plus">
                            <div class="news-content">${bNews.content}</div>
                            <div class="plus-news">
                                <a href=" <c:url value="/visitor/news?id=${bNews.id} "/>" >
                                    <img src="<c:url value="/assets/photos/plus-jaune.png"/>" alt="En savoir plus"/>
                                </a>
                            </div>
                        </div>
                        <div class="score-news">
                            ${bNews.score}
                            <img src="<c:url value="/assets/photos/thumbs-up.png"/>" alt="Pouce en l'air"/>
                        </div>
                    </div>
                </article>
            </c:forEach>
        </div>
        <div class="allNews">  
            <c:forEach var="news" items="${requestScope.allNews}">
                <article class="news">
                    <div class="img-news">
                        <img src="<c:url value="/assets/photos/icons8-fake-news-64.png"/>" alt="L'image de l'article"/>
                    </div>
                    <div class="text-news">
                        <h3>${news.title}</h3>
                        <div>&Eacute;crit par ${news.author.login} le ${news.created}</div>
                        <div class="text-plus">
                            <div class="news-content">${news.content}</div>
                            <div class="plus-news">
                                <a href=" <c:url value="/visitor/news?id=${news.id} "/>" >
                                    <img src="<c:url value="/assets/photos/plus-vert.png"/>" alt="En savoir plus"/>
                                </a>
                            </div>
                        </div>
                        <div class="score-news">
                            ${news.score}
                            <img src="<c:url value="/assets/photos/thumbs-up.png"/>" alt="Pouce en l'air"/>
                        </div>
                    </div>
                </article>
            </c:forEach>
        </div>  
    </div>
</div>
