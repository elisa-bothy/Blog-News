<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="form">
    <h2>Votre profil</h2>
    <div class="ok">${requestScope.changed}</div>
    <p>Identifiant interne : ${sessionScope.user.id}</p>
    <p>Login : ${sessionScope.user.login}</p>
    <c:if test="${user.id !=1}">
        <a href="<c:url value="/user/activeUser"/>?id=${user.id}"><span  class="button">Desactiver</span></a>
    </c:if>
    <section>
        <h3>Changer de mot de passe</h3>
        <form action="<c:url value="/user/profile"/>" method="post">
            <fieldset>
            <legend>Modifications</legend>
            <div>
                <label for="pwd">Mot de passe actuel</label>
                <input type="password" id="password" name="password">
                <div class="error">${requestScope.errors.pwd}</div>
            </div>
            <div>
                <label for="next">Nouveau mot de passe</label>
                <input type="password" id="newPassword" name="next">
                <div class="error">${requestScope.errors.next}</div>
            </div>
            <div>
                <label for="verif">Vérification</label>
                <input type="password" id="verif" name="verif">
                <div class="error">${requestScope.errors.verif}</div>
            </div>
        </fieldset>
        <div class="buttons">
            <input type="submit" value="Envoyer">
            <input type="reset" value="Annuler">
        </div>
        </form>
    </section>
</div>