/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import dao.CommentDao;
import dao.DAOFactory;
import dao.NewsDao;
import entities.Person;
import entities.Vote;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Elisa Bothy
 */
@WebServlet("/user/thumbsDown")
@SuppressWarnings("serial")
public class ThumbsDown extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            HttpSession session = req.getSession();
            Person user = (Person) session.getAttribute("user");
            int idNews = Integer.parseInt(req.getParameter("id"));
            Vote vote = new Vote();
            vote.setId_news(idNews);
            vote.setScore(-1);
            vote.setId_user(user.getId());
            DAOFactory.getVoteDao().save(vote);
            req.setAttribute("message", "Votre vote a bien été pris en compte");
            resp.sendRedirect(req.getContextPath() + "/visitor/news?id="+idNews);
        } catch (IllegalArgumentException ex) {
            resp.sendError(404);
        }
    }
}