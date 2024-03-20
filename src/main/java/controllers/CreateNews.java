/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import forms.CreateNewsFormChecker;
import entities.News;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Igor Martellote
 */
@WebServlet("/user/createNews")
@MultipartConfig
@SuppressWarnings("serial")
public class CreateNews extends HttpServlet {

    private static final String IMAGES_FOLDER = "/assets/photos/";
    private String uploadPath;

    @Override
    public void init() throws ServletException {
        // Si le répertoire destination n'existe pas on le créé
        uploadPath = getServletContext().getRealPath(IMAGES_FOLDER);
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/WEB-INF/user/createNews.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // on récupère l'image
        // "file" est la clé sous laquelle est envoyé le fichier (attribut name dans le HTML)
        Part filePart = req.getPart("file");
        String fileName = getFilename(filePart);
        String fullPath = uploadPath + File.separator + fileName;
        filePart.write(fullPath);
        req.setAttribute("filename", fileName);
        CreateNewsFormChecker cnfc = new CreateNewsFormChecker(req);
        News news = cnfc.checkForm();
        if (cnfc.getErrors().isEmpty()) {
            resp.sendRedirect(req.getContextPath() + "/");
        } else {
            req.getRequestDispatcher("/WEB-INF/user/createNews.jsp").forward(req, resp);
        }

    }

    private String getFilename(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf("=") + 2, content.length() - 1);
            }
        }
        return "Default.file";
    }

}
