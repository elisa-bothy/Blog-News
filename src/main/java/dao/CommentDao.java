/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entities.Comment;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Guillaume Rostagnat
 */
public class CommentDao extends DAO<Comment> {

    public CommentDao() {
        super("person");
    }

    @Override
    protected Comment createObject(ResultSet rs) throws SQLException {
        Comment obj = new Comment();
        obj.setId(rs.getInt("id"));
        obj.setContent(rs.getString("content"));
        obj.setCreated(rs.getTimestamp("created"));
        obj.setAuthor(DAOFactory.getPersonDao().read(rs.getInt("author")));
        obj.setId_news(rs.getInt("id_news"));
        return obj;

    }

    @Override
    protected void create(Comment obj) {

        String sql = "INSERT INTO " + table
                + " (content, created, author) VALUES (?, ?, ?, ?)";
        try ( PreparedStatement pstmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, obj.getContent());
            pstmt.setTimestamp(2, obj.getCreated());
            pstmt.setInt(3, obj.getAuthor().getId());
            pstmt.setInt(4, obj.getId_news());

            int nbLines = pstmt.executeUpdate();
            if (nbLines == 1) {
                ResultSet generatedKeys = pstmt.getGeneratedKeys();
                generatedKeys.first();
                int id = generatedKeys.getInt(1);
                obj.setId(id);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void update(Comment obj) {
        String sql = "UPDATE " + table
                + " SET content=?, created=?, author=?, id_news=?, WHERE id=?";
        try ( PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, obj.getContent());
            pstmt.setTimestamp(2, obj.getCreated());
            pstmt.setInt(3, obj.getAuthor().getId());
            pstmt.setInt(4, obj.getId_news());
            pstmt.setInt(5, obj.getId());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CommentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Collection<Comment> listLast(int qty) {
        ArrayList<Comment> list = new ArrayList<>();
        String sql = "SELECT * FROM " + table + " ORDER BY created DESC LIMIT ?";
        try ( PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, qty);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Comment obj = createObject(rs);
                list.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommentDao.class.getName()).log(Level.SEVERE, "Erreur lors du listage : {0}", ex.getMessage());
        }
        return list;
    }

}
