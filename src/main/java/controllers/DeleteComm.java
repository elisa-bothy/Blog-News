/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import dao.CommentDao;
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
@WebServlet("admin/deletecomm")
public class DeleteComm extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("commId"));
            entities.Comment comment = new CommentDao().read(id);
            if (comment == null) {
                throw new IllegalArgumentException();
            } else {
                new CommentDao().delete(id);
                resp.sendRedirect(req.getContextPath() + "/admin/comm");
            }
        } catch (IllegalArgumentException ex) {
            resp.sendError(404);
        }
    }

}