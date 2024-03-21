/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entities.News;
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
        obj.setFilename(rs.getString("filename"));
        return obj;

    }

    @Override
    public void create(News obj) {
        String sql = "INSERT INTO " + table
                + " (title, content, created, author, filename) VALUES (?, ?, ?, ?, ?)";
        try ( PreparedStatement pstmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, obj.getTitle());
            pstmt.setString(2, obj.getContent());
            pstmt.setTimestamp(3, obj.getCreated());
            pstmt.setInt(4, obj.getAuthor().getId());
            pstmt.setString(5, obj.getFilename());
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
                + " SET title=?, content=?, created=?, author=?, filename=? WHERE id?";
        try ( PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, obj.getTitle());
            pstmt.setString(2, obj.getContent());
            pstmt.setTimestamp(3, obj.getCreated());
            pstmt.setInt(4, obj.getAuthor().getId());
            pstmt.setString(5, obj.getFilename());
            //pstmt.setInt(6, obj.getId());

            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NewsDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Collection<News> listLast() {
        ArrayList<News> list = new ArrayList<>();
        String sql = "SELECT * FROM " + table + " ORDER BY created DESC LIMIT 10";
        try ( PreparedStatement pstmt = connection.prepareStatement(sql)) {
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

    public Object listBestN(int qty) {
        ArrayList<News> list = new ArrayList<>();
        String sql = "SELECT *, SUM(score) AS total_score FROM news inner JOIN vote on vote.id_news = news.id GROUP BY news.id order by sum(score) desc limit ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)){
            pstmt.setInt(1, qty);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                News n = new News();
                n.setId(rs.getInt("id"));
                n.setTitle(rs.getString("title"));
                n.setContent(rs.getString("content"));
                n.setCreated(rs.getTimestamp("created"));
                n.setAuthor(new PersonDao().read(rs.getInt("author")));
                list.add(n);
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors du listage :" + ex.getMessage());
        }
        return list;
    }

    public Collection<News> listLastN(int qty){
        ArrayList<News> list = new ArrayList<>();
        String sql = "SELECT * FROM news ORDER BY created DESC LIMIT ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)){
            pstmt.setInt(1, qty);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                News n = new News();
                n.setId(rs.getInt("id"));
                n.setTitle(rs.getString("title"));
                n.setContent(rs.getString("content"));
                n.setCreated(rs.getTimestamp("created"));
                n.setAuthor(new PersonDao().read(rs.getInt("author")));
                list.add(n);
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors du listage :" + ex.getMessage());
        }
        return list;
    }

}
