/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import dao.DAOFactory;
import entities.Comment;
import forms.CreateCommentFormChecker;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Valentina Sarais
 */
@WebServlet("/visitor/news")
@SuppressWarnings("serial")
public class News extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Récupérer l'ID de l'article depuis l'URL
            int id = Integer.valueOf(request.getParameter("id"));
            entities.News news = DAOFactory.getNewsDao().read(id);
            Comment comment = DAOFactory.getCommentDao().read(id);
            if (news == null) {
                // Gérer l'erreur si l'article avec l'ID spécifié n'existe pas
                throw new IllegalArgumentException();
            } else {
                // Passer l'article à la page JSP
                List<Comment> comments = (List<Comment>) DAOFactory.getCommentDao().listByNewsId(id);
                request.setAttribute("news", news);
                request.setAttribute("comments", comments);
                request.getRequestDispatcher("/WEB-INF/visitor/news.jsp").
                        forward(request, response);
            }
        } catch (IllegalArgumentException ex) {
            // Gérer l'erreur si l'ID n'est pas un nombre valide
            response.sendError(404);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // récupérer les données du formulaire et les vérifier
        CreateCommentFormChecker fc = new CreateCommentFormChecker(req);
        Comment comment = fc.checkForm();
        // Si erreur => affichage formulaire sinon affichage page OK
        if (fc.getErrors().isEmpty()) {
            req.setAttribute("comment", comment);
            req.getRequestDispatcher("/WEB-INF/visitor/news.jsp")
                    .forward(req, resp);
        }
    }
}
