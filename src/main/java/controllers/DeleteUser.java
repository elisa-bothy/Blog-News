/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import dao.PersonDao;
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
@WebServlet("/admin/deleteuser")
@SuppressWarnings("serial")
public class DeleteUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("userId"));
            entities.Person person = new PersonDao().read(id);
            if (person == null) {
                throw new IllegalArgumentException();
            } else {
                new PersonDao().delete(id);
                resp.sendRedirect(req.getContextPath() + "/admin/user");
            }
        } catch (IllegalArgumentException ex) {
            resp.sendError(404);
        }
    }
}
