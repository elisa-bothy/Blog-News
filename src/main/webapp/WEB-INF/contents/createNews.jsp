<%-- any content can be specified here e.g.: --%>
<%@ page pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${user != null}">
    <div class="pageForm">
    <form action="<c:url value="/user/createNews"/>" method="post" class="formLoginForm" enctype="multipart/form-data">
        <div>
            <h1>Creation de News</h1>
            <p id="paragraphForm">Ecrivez et postulez</p>
        </div>
        <div>
            <label for="title">Title</label>
        </div>
        <div>
            <input id="title" name="title" autofocus="true" />
            <span class="error">${requestScope.errors.title}</span>
        </div>
        <div>
            <label for="content">Text</label>
        </div>
        <div>
            <textarea id="content" name="content" ></textarea>
            <span class="error">${requestScope.errors.content}</span>
        </div>
        <div>
            <label for="file">Votre avatar </label>
            <input type="file" id="file"
                   accept="image/png" name="file">
        </div>
        <div>
            <input type="submit" value="Valider" class="btn" />
            <input type="reset" value="Effacer" class="btn" />
        </div>
    </form>
            <div/>
</c:if>
