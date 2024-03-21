/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package forms;

import entities.Person;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Igor Martellote
 */
public class ChangeActiveUserFormChecker extends FormChecker<Person> {

    private Boolean active;

    public ChangeActiveUserFormChecker(Boolean active, HttpServletRequest request) {
        super(request);

    }

    @Override
    public Person checkForm() {


    }

}
