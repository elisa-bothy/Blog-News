/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import entities.Person;
import forms.ConnectFormChecker;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Valentina Sarais
 */
@WebServlet ("/visitor/connect")
@SuppressWarnings("serial")
public class Connect extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/visitor/connect.jsp").forward(req, resp);
    }
    
     @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        // récupérer les données du formulaire et les vérifier
        ConnectFormChecker fc = new ConnectFormChecker(req);
        Person p = fc.checkForm();
        // Si erreur => affichage formulaire sinon affichage page OK
        if (fc.getErrors().isEmpty()) {
            HttpSession session = req.getSession();
            session.setAttribute("user", p);
            resp.sendRedirect(req.getContextPath()+"/visitor/index");
        } else {
            req.getRequestDispatcher("/WEB-INF/visitor/connect.jsp")
                    .forward(req, resp);
        }
    }
    
}
  
   
