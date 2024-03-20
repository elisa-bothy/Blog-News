package forms;

import dao.DAOFactory;
import entities.Person;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Valentina Sarais
 */
public class ConnectFormChecker extends FormChecker<Person> {

    public ConnectFormChecker(HttpServletRequest request) {
        super(request);
    }

    @Override
    public Person checkForm() {
        Person obj = new Person();
        // hydrater le bean avec les données du formulaire
        String login = getParameter("login");
        String pwd = getParameter("password");
        obj.setLogin(login);
        obj.setPassword(password);
        // Vérifier les données du formulaire
        // Vérifier si les champs sont remplis
        if (login.trim().length() == 0) {
            setError("login", "Ce champ doit être rempli.");
        }
        if (pwd.length() == 0) {
            setError("pwd", "Ce champ doit être rempli.");
        }
        // Si formulaire acceptable => vérifier le couple login/pwd
        if (errors.isEmpty()) {
            // Vérifier en DB que cet utilisateur existe
            // et qu'il a donné le bon pwd
            Person read = DAOFactory.getPersonDao().read(login);
            if (read == null || !pwd.equals(read.getPassword())) {
                setError("login", "Ces informations ne nous permettent pas de vous connecter.");
            } else {
                obj.setId(read.getId());
                request.getSession().setAttribute("user", obj);
            }
        }
        // associer les messages d'erreur et le bean à la requête 
        request.setAttribute("errors", errors);
        request.setAttribute("bean", obj);
        return obj;
    }

}
