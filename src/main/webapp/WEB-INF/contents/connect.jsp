
<%-- 
    Document   : connect
    Created on : 20 mars 2024, 09:42:30
    Author     : Igor Martellote
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="form">
    <h1>Veuillez entrer vos paramètres de connexion</h1>
    <div class="error">${requestScope.errorMsg}</div>
    <fieldset>
        <legend>Connexion</legend>
        <form action="<c:url value="/visitor/connect" />" method="post">
            <div>
                <input placeholder="Email" type ="email" pattern=".+@mail\.com" id="login" name="login" value="${requestScope.bean.login}" autofocus="true">
                <div class="error">${requestScope.errors.login}</div>
            </div>
            <div>
                <input placeholder="Password" id="password" name="password" type="password">
                <div class="error">${requestScope.errors.password}</div>
            </div>
            <div class="buttons">
                <input type="submit" value="Envoyer">
                <input type="reset" value="Annuler">
            </div>
        </form>
    </fieldset>
</div>
