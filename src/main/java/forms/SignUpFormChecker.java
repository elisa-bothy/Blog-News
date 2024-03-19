///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//
//package forms;
//
//import javax.servlet.http.HttpServletRequest;
//import entities.Person;
//
///**
// *
// * @author Igor Martellote
// */
//public class SignUpFormChecker extends FormChecker<Person> {
//
//    public SignUpFormChecker(HttpServletRequest request) {
//        super(request);
//    }
//
//    @Override
//    public Person checkForm() {
//        //PersonDAOBlog pdaob = new PersonDAOBlog();
//        Person obj = new Person();
//        //hydrater le bean avec les donnes form
//        String login = getParameter("login");
//        String pwdForm = getParameter("pwdForm");
//        String pwdForm2 = getParameter("pwdForm2");
//
//        obj.setLogin(login);
//        obj.setPassword(pwdForm);
//
//        // obj.setPassword(pwdForm2);
//        //verifier les donnes du Formulaire
//        //verifier si les champs sont remplis
//        if (login == null || login.trim().length() < 3) {
//            setErrors("login", "Ce champ doit etre rempli au moins caracteres");
//        }
//        if (pwdForm == null || pwdForm.length() < 5) {
//            setErrors("pwdForm", "Ce champ doit etre rempli au moins caracteres");
//        }
//        if (!pwdForm2.equals(pwdForm)) {
//            setErrors("pwdForm2", "Les mots de passe sont pas pareil");
//        }
//        PersonDAO pdao = new PersonDAO();
//        Person fromDb = pdao.read(login);
//        if (errors.isEmpty()) {
//            if (!(fromDb == null)) {
//                setErrors("already", "user utilise");
//            } else {
//                pdao.create(obj);
//            }
//
//        }
//
//        //ass;ocie les msg de errors et le bean a la requete
//        request.setAttribute("errors", errors);
//        request.setAttribute("bean", obj);
//        return obj;
//    }
//
//}
