<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container" id="container">
    <div id="articles">
        <c:if test="${! empty sessionScope.user}">
            <a class="createNews" href="<c:url value="/user/createNews"/>"><span  class="button">Créer une nouvelle News</span></a>
        </c:if>
        <div class="bestNews">
            <c:forEach var="bNews" items="${requestScope.bestNews}">
                <div class="article">
                    <a href=" <c:url value="/visitor/news?id=${bNews.id} "/>" class="article-link">
                        <article class="bNews">
                            <div class="img-news">
                                <img src="<c:url value='/assets/photos/${bNews.filename}'/>" alt="${bNews.title}"/>
                            </div>
                            <div class="text-news">
                                <h3>${bNews.title}</h3>
                                <div>&Eacute;crit par ${bNews.author.login} le ${bNews.created}</div>
                                <div class="text-plus">
                                    <div class="news-content">${bNews.content}</div>
                                </div>
                                <div class="more-score">
                                    <div class="more-content">
                                        <img src="<c:url value="/assets/photos/plus-jaune.png"/>" alt="En savoir plus"/>
                                    </div>
                                    <div class="score-news">
                                        ${bNews.score}
                                        <img src="<c:url value="/assets/photos/thumbs-up.png"/>" alt="Pouce en l'air"/>
                                    </div>
                                </div>
                            </div>
                        </article>
                    </a>
                </div>
            </c:forEach>
        </div>
        <div class="allNews">  
            <c:forEach var="news" items="${requestScope.allNews}">
                <div class="article">
                    <a href=" <c:url value="/visitor/news?id=${news.id} "/>" class="article-link">
                        <article class="news">
                            <div class="img-news">
                                <img src="<c:url value='/assets/photos/${news.filename}'/>" alt="${news.title}"/>
                            </div>
                            <div class="text-news">
                                <h3>${news.title}</h3>
                                <div>&Eacute;crit par ${news.author.login} le ${news.created}</div>
                                <div class="text-plus">
                                    <div class="news-content">${news.content}</div>
                                </div>
                                <div class="more-score">
                                    <div class="more-content">
                                        <img src="<c:url value="/assets/photos/plus-vert.png"/>" alt="En savoir plus"/>
                                    </div>
                                    <div class="score-news">
                                        ${news.score}
                                        <img src="<c:url value="/assets/photos/thumbs-up.png"/>" alt="Pouce en l'air"/>
                                    </div>
                                </div>
                            </div>
                        </article>
                    </a>
                </div>
            </c:forEach>
        </div>  
    </div>
</div>
