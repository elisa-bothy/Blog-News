/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import dao.CommentDao;
import dao.DAOFactory;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Guillaume Rostagnat
 */
@WebServlet("/visitor/signalComment")
@SuppressWarnings("serial")
public class SignalComment extends HttpServlet {


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int idNews = Integer.parseInt(req.getParameter("id"));
            int id = Integer.parseInt(req.getParameter("commId"));
            entities.Comment comment = new CommentDao().read(id);
            if (comment == null) {
                throw new IllegalArgumentException();
            } else {
                comment.setState(1);
                DAOFactory.getCommentDao().save(comment);
                resp.sendRedirect(req.getContextPath() + "/visitor/news?id="+idNews);
            }
        } catch (IllegalArgumentException ex) {
            resp.sendError(404);
        }
    }
}
