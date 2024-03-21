    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import dao.NewsDao;
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
@WebServlet("/admin/deleteNews")
@SuppressWarnings("serial")
public class DeleteNews extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("newsId"));
            entities.News news = new NewsDao().read(id);
            if (news == null) {
                throw new IllegalArgumentException();
            } else {
                new NewsDao().delete(id);
                resp.sendRedirect(req.getContextPath() + "/admin/news");
            }
        } catch (IllegalArgumentException ex) {
            resp.sendError(404);
        }
    }
}
