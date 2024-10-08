/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forms;

import dao.DAOFactory;
import entities.Comment;
import entities.Person;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Valentina Sarais
 */
public class CreateCommentFormChecker extends FormChecker<Comment> {

    public CreateCommentFormChecker(HttpServletRequest request) {
        super(request);
    }

    @Override
    public Comment checkForm() {
        Comment obj = new Comment();
        Person author = (Person) request.getSession().getAttribute("user");
        // hydrater le bean avec les données du formulaire
        String content = getParameter("content");
        obj.setAuthor(author);
        obj.setContent(content);
        obj.setCreated(Timestamp.valueOf(LocalDateTime.now()));
        obj.setId_news(Integer.valueOf(request.getParameter("id")));
        // Vérifier les données du formulaire
        // Vérifier si les champs sont remplis
        if (content.length() == 0) {
            setErrors("content", "Ce champ doit être rempli.");
        } else {
            Comment read = DAOFactory.getCommentDao().readContent(content);
            if (read != null) {
                setErrors("content", "Veuillez écrire un nouveau commentaire !");
            } else {
                DAOFactory.getCommentDao().save(obj);
                setMessages("newComment", "Votre message a bien été crée");
            }

        }
        // associer les messages d'erreur et le bean à la requête 
        request.setAttribute("errors", errors);
        request.setAttribute("messages", messages);
        request.setAttribute("bean", obj);
        return obj;
    }
}
