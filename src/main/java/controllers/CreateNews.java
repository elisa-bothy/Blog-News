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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Igor Martellote
 */
@WebServlet("/user/createNews")
@SuppressWarnings("serial")
public class CreateNews extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/WEB-INF/user/createNews.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CreateNewsFormChecker cnfc = new CreateNewsFormChecker(req);
        News news = cnfc.checkForm();
        if (cnfc.getErrors().isEmpty()) {
            HttpSession session = req.getSession();
            session.setAttribute("user", news);
            //resp.sendRedirect(req.getContextPath() + "/");
            req.getRequestDispatcher("/visitor/index.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/WEB-INF/user/createNews.jsp").forward(req, resp);
        }

    }


}
