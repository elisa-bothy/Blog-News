/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entities.Vote;
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
public class VoteDao extends DAO<Vote> {

    public VoteDao() {
        super("vote");
    }

    @Override
    protected Vote createObject(ResultSet rs) throws SQLException {
        Vote obj = new Vote();
        obj.setId(rs.getInt("id"));
        obj.setScore(rs.getInt("score"));
        obj.setId_user(rs.getInt("id_user"));
        obj.setId_news(rs.getInt("id_news"));
        return obj;
    }

    @Override
    protected void create(Vote obj) {
        String sql = "INSERT INTO " + table
                + " (score, id_user, id_news) VALUES (?, ?, ?)";
        try ( PreparedStatement pstmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, obj.getScore());
            pstmt.setInt(2, obj.getId_user());
            pstmt.setInt(3, obj.getId_news());
            int nbLines = pstmt.executeUpdate();
            if (nbLines == 1) {
                ResultSet generatedKeys = pstmt.getGeneratedKeys();
                generatedKeys.first();
                int id = generatedKeys.getInt(1);
                obj.setId(id);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VoteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void update(Vote obj) {
        String sql = "UPDATE " + table
                + " SET Score=?, id_user=?, id_news=?, WHERE id=?";
        try ( PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, obj.getScore());
            pstmt.setInt(2, obj.getId_user());
            pstmt.setInt(3, obj.getId_news());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VoteDao.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public Collection<Vote> listLast(int qty) {
        ArrayList<Vote> list = new ArrayList<>();
        String sql = "SELECT * FROM " + table + " ORDER BY created DESC LIMIT ?";
        try ( PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, qty);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Vote obj = createObject(rs);
                list.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VoteDao.class.getName()).log(Level.SEVERE, "Erreur lors du listage : {0}", ex.getMessage());
        }
        return list;
    }
    
    public int scoreById(int newsId) {
         int score = 0;
        String sql = "SELECT SUM(score) AS total_score FROM `vote` WHERE id_news = ?";
        try ( PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, newsId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
               score = rs.getInt("total_score");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommentDao.class.getName()).log(Level.SEVERE, "Erreur lors du listage des commentaires pour la news avec l''ID {0} : {1}", new Object[]{newsId, ex.getMessage()});
        }
        return score;
    }

}
