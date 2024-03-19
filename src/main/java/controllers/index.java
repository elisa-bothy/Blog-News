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
 * @author Herbert Caffarel
 */
@WebServlet("/visitor/index")
@SuppressWarnings("serial")
public class index extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req
                .setAttribute("bestNews", DAOFactory.getNewsDao().listBestN(3));
        req
                .setAttribute("allNews", DAOFactory.getNewsDao().listLastN(10));
        req
                .getRequestDispatcher("/WEB-INF/visitor/index.jsp").forward(req, resp);
    }

}
