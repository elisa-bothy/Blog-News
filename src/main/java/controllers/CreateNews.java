/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controllers;

import forms.CreateNewsFormChecker;
import entities.News;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Igor Martellote
 */
@WebServlet("/createNews")
@SuppressWarnings("serial")
public class CreateNews extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("user") != null) {
            req.getRequestDispatcher("/WEB-INF/user/createNews.jsp").forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CreateNewsFormChecker cnfc = new CreateNewsFormChecker(req);
        News news = cnfc.checkForm();
        if (cnfc.getErrors().isEmpty()) {
            resp.sendRedirect(req.getContextPath() + "/");

        } else {

            req.getRequestDispatcher("/WEB-INF/user/createNews.jsp").forward(req, resp);
        }

    }


}
