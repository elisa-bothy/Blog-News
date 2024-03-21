/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controllers;

import dao.DAOFactory;
import dao.PersonDao;
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
@WebServlet("/admin/adminDesactiveUser")
@SuppressWarnings("serial")
public class AdminDesactiveUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        entities.Person person = new PersonDao().read(id);
        if (person == null) {
            throw new IllegalArgumentException();
        } else {
            person.setActive(false);
            DAOFactory.getPersonDao().save(person);
            request.getRequestDispatcher("/WEB-INF/admin/adminUser.jsp").forward(request, response);
        }
    }
}
