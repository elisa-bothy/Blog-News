<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="form">
    <fieldset>
        <form action="<c:url value="signUp"/>" method="POST" class="formLoginForm">
            <div>
                <h1>Inscription</h1>
                <p id="paragraphForm">Entrez vos données pour vous inscrire</p>
            </div>
            <div>
                <label for="loginSignup">Login</label>
            </div>
            <div>
                <input id="loginSignup" name="login" value="${requestScope.bean.login}" autofocus="true" />
                <span class="error">${requestScope.errors.already}</span>
            </div>
            <div>
                <span class="error">${requestScope.errors.loginSignup}</span>

            </div>

            <div>
                <label for="password">Password</label>
            </div>
            <div>
                <input id="pwdForm"  name="pwdForm" type="password" value="${requestScope.Person.password}" />
            </div>
            <div>
                <label for="password">Retaper votre Password</label>
            </div>
            <div>
                <input id="pwdForm2"  name="pwdForm2" type="password" value="${requestScope.Person.password}" />
                <span class="error">${requestScope.errors.pwdForm2}</span>
            </div>
            <div>

            </div>
            <div>
                <input type="submit" value="Valider"  />
            </div>
        </form>
    </fieldset>
</div>
