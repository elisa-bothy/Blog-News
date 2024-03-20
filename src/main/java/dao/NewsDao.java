/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entities.News;
import entities.Person;
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
public class NewsDao extends DAO<News> {

    public NewsDao() {
        super("news");
    }

    @Override
    protected News createObject(ResultSet rs) throws SQLException {
        News obj = new News();
        obj.setId(rs.getInt("id"));
        obj.setTitle(rs.getString("title"));
        obj.setContent(rs.getString("content"));
        obj.setAuthor(DAOFactory.getPersonDao().read(rs.getInt("author")));
        return obj;

    }

    @Override
    public void create(News obj) {
        String sql = "INSERT INTO " + table
                + " (title, content, created, author) VALUES (?, ?, ?, ?)";
        try ( PreparedStatement pstmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, obj.getTitle());
            pstmt.setString(2, obj.getContent());
            pstmt.setTimestamp(3, obj.getCreated());
            pstmt.setInt(4, obj.getAuthor().getId());
            int nbLines = pstmt.executeUpdate();
            if (nbLines == 1) {
                ResultSet generatedKeys = pstmt.getGeneratedKeys();
                generatedKeys.first();
                int id = generatedKeys.getInt(1);
                obj.setId(id);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NewsDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void update(News obj) {
        String sql = "UPDATE " + table
                + " SET title=?, content=?, created=?, author=? WHERE id?";
        try ( PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, obj.getTitle());
            pstmt.setString(2, obj.getContent());
            pstmt.setTimestamp(3, obj.getCreated());
            pstmt.setInt(4, obj.getAuthor().getId());
            pstmt.setInt(5, obj.getId());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NewsDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Collection<News> listLast(int qty) {
        ArrayList<News> list = new ArrayList<>();
        String sql = "SELECT * FROM " + table + " ORDER BY created DESC LIMIT ?";
        try ( PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, qty);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                News obj = createObject(rs);
                list.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NewsDao.class.getName()).log(Level.SEVERE, "Erreur lors du listage : {0}", ex.getMessage());
        }
        return list;
    }

}
