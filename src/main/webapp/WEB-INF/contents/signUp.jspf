<%-- any content can be specified here e.g.: --%>
<%@ page pageEncoding="UTF-8" %>
<div class="pageForm">
    <form action="<c:url value="signUp"/>" method="POST" class="formLoginForm">
    <div>
        <h1>Sign UP</h1>
        <p id="paragraphForm">Tapez vos donnees pour vous inscrire</p>
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
        <input type="submit" value="Valider" class="btn" />
    </div>

</form>
</div>
