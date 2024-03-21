/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

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
@WebServlet("/admin/user")
@SuppressWarnings("serial")
public class AdminUser extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      req
                .setAttribute("users", DAOFactory.getPersonDao().list());
        req
                .getRequestDispatcher("/WEB-INF/admin/adminUser.jsp").forward(req, resp);
    }
}
    
    
    
