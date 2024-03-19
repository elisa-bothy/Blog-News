/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forms;

import dao.DAOFactory;
import entities.Person;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Valentina Sarais
 */
public class ChangePasswordFormChecker extends FormChecker<Person>{
    
    private final int MIN_PWD_LENGTH = 5;
    private final String PASSWORD_FIELD = "password";
    private final String NEW_PASSWORD_FIELD = "next";
    private final String VERIF_FIELD = "verif";    

    public ChangePasswordFormChecker(HttpServletRequest request) {
        super(request);
    }

    @Override
    public Person checkForm() {
        String password = getParameter(PASSWORD_FIELD);
        String newPassword = getParameter(NEW_PASSWORD_FIELD);
        String verif = getParameter(VERIF_FIELD);
        Person user = (Person)request.getSession().getAttribute("user");
        
        if (!user.getPassword().equals(password)) {
            setErrors(PASSWORD_FIELD, "Mot de passe incorrect");
        }
        if (newPassword.length() < MIN_PWD_LENGTH) {
            setErrors(NEW_PASSWORD_FIELD, "Ce champ doit faire au moins " 
                    + MIN_PWD_LENGTH + " lettres.");
        }
        if (!newPassword.equals(verif)) {
            setErrors(VERIF_FIELD, "Les mots de passe ne concordent pas.");
        }
        if (errors.isEmpty()) {
            user.setPassword(newPassword);
            DAOFactory.getPersonDao().save(user);
        }
        
        request.setAttribute("errors", errors);
        request.setAttribute("bean", user);
        return user;
    }
    
}

