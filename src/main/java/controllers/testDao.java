/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import dao.CommentDao;
import dao.DAOFactory;
import dao.PersonDao;
import entities.Comment;
import entities.Person;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Guillaume Rostagnat
 */
@WebServlet("/test")
public class testDao extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CommentDao cdao = new CommentDao();
        Comment c = new Comment();

        c.setContent("blabla");
        c.setCreated(Timestamp.valueOf(LocalDateTime.MIN));
        c.setAuthor(DAOFactory.getPersonDao().read(1));
        System.out.println(c);
        cdao.save(c);

// Créer ou updater une news
//art.setAuthor(DAOFactory.getPersonDao().read(1));
//art.setContent("lorem content");
//art.setCreated(Timestamp.valueOf(LocalDateTime.now()));
//art.setTitle("un titre");
//System.out.println("creation d'article en BD");
//adao.save(art);
//System.out.println("art = " + art);
//art.setContent("un autre contenu");
//art.setTitle("changement");
//System.out.println("modif article");
//adao.save(art);
//System.out.println("art = " + art);
//
//Effacer une news
//System.out.println("suppression article");
//adao.delete(art.getId());
    }
}
