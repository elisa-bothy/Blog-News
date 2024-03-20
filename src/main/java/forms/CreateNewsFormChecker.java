/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package forms;

import javax.servlet.http.HttpServletRequest;
import dao.NewsDao;
import entities.News;
import entities.Person;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 *
 * @author Igor Martellote
 */
public class CreateNewsFormChecker extends FormChecker<News> {

    public CreateNewsFormChecker(HttpServletRequest request) {
        super(request);
    }

    @Override
    public News checkForm() {
        News news = new News();
        NewsDao ndao = new NewsDao();
        String title = getParameter("title");
        String content = getParameter("content");
        String filename = (String) request.getAttribute("filename");
        news.setTitle(title);
        news.setContent(content);
        news.setAuthor((Person) request.getSession().getAttribute("user"));
        news.setCreated(Timestamp.valueOf(LocalDateTime.now()));
        news.setFilename(filename);
        if (title.trim().length() == 0) {
            setErrors("title", "Ce champ doit etre rempli au moins 5 caracteres");
        }
        if (content.length() == 0) {
            setErrors("content", "Ce champ doit etre rempli au moins 15 caracteres");
        }
        if (errors.isEmpty()) {
            ndao.save(news);
            System.out.println("news = " + news);
        }
        request.setAttribute("errors", errors);
        request.setAttribute("bean", news);
        return news;
    }


}
