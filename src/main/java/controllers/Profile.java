/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import entities.Person;
import forms.ChangePasswordFormChecker;
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
@WebServlet("/user/profile")
@SuppressWarnings("serial")

public class Profile extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();
        req.getRequestDispatcher("/WEB-INF/user/profile.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        if (req.getSession().getAttribute("user") == null) {
            resp.sendRedirect(req.getContextPath() + "/");
            return;
        }
        ChangePasswordFormChecker fc = new ChangePasswordFormChecker(req);
        Person obj = fc.checkForm();
        if (fc.getErrors().isEmpty()) {
            req.setAttribute("changed", "Votre mot de passe a été changé");
            req.getRequestDispatcher("/WEB-INF/user/profile.jsp").forward(req, resp);
        }
    }
}
