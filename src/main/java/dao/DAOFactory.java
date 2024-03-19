/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author Guillaume Rostagnat
 */
public class DAOFactory {

    private static PersonDao personDao;
    private static CommentDao commentDao;
    private static NewsDao newsDao;
    private static VoteDao voteDao;

    public DAOFactory() {
    }

    public static PersonDao getPersonDao() {

        if (personDao == null) {
            personDao = new PersonDao();
        }
        return personDao;

    }

    public static NewsDao getNewsDao() {

        if (newsDao == null) {
            newsDao = new NewsDao();
        }
        return newsDao;

    }

    public static CommentDao getCommentDao() {

        if (commentDao == null) {
            commentDao = new CommentDao();
        }
        return commentDao;

    }

    public static VoteDao getVoteDao() {

        if (voteDao == null) {
            voteDao = new VoteDao();
        }
        return voteDao;

    }

}
