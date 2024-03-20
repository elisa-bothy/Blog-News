/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controllers;

import entities.Person;
import forms.SignUpFormChecker;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Igor Martellote
 */
@WebServlet("/visitor/signUp")
@SuppressWarnings("serial")
public class SignUp extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/visitor/signUp.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        // recuperer les donnes du FORM
        SignUpFormChecker sufc = new SignUpFormChecker(req);
        Person pers = sufc.checkForm();
        //on verifie les donnes: user and password
        if (sufc.getErrors().isEmpty()) {
            HttpSession session = req.getSession();
            session.setAttribute("user", pers);

            req.getRequestDispatcher("/visitor/index.jsp").forward(req, resp);
        } else {
            HttpSession session = req.getSession();
            session.setAttribute("user", pers);
            req.getRequestDispatcher("/WEB-INF/visitor/signUp.jsp").forward(req, resp);
        }
    }


}
