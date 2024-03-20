/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import dao.PersonDao;
import entities.Person;
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
@WebServlet("/test")
public class testDao extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PersonDao pdao = new PersonDao();
        Person p = new Person();

        p.setLogin("archie");
        p.setPassword("null");
        System.out.println(p);
        pdao.save(p);

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
