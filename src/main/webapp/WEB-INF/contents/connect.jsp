<<<<<<< HEAD
<%-- 
    Document   : connect
    Created on : 20 mars 2024, 09:42:30
    Author     : Igor Martellote
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
>>>>>>> origin/communVale
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>Veuillez entrer vos paramètres de connexion</h1>
<div class="error">${requestScope.errorMsg}</div>
<form action="<c:url value="/visitor/connect" />" method="post">
    <fieldset>
        <legend>Connexion</legend>
        <div>
            <label for="login">Login</label>
            <input id="login" name="login" value="${requestScope.bean.login}" autofocus="true">
            <div class="error">${requestScope.errors.login}</div>
        </div>
        <div>
            <label for="pwd">Password</label>
            <input id="password" name="password" type="password">
            <div class="error">${requestScope.errors.password}</div>
        </div>
    </fieldset>
    <div class="buttons">
        <input type="submit" value="Envoyer">
        <input type="reset" value="Annuler">
    </div>
</form>
