package dao;

import entities.Identifiable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Superclasse pour définir une DAO spécialisée dans un type d'objet.
 *
 * @author Herbert Caffarel
 * @param <T> L'entité à utiliser dans la DAO
 */
public abstract class DAO<T extends Identifiable> {

    protected Connection connection;
    protected String table;
    protected static Properties config;

    // Ce code est exécuté avant toute autre chose, même avant le constructeur
    // Ça permet de récupérer des données en amont, comme ici la configuration
    // de la base de données pour pouvoir l'utiliser dans les classes filles.
    static {
//        config = Helpers.ConfigHelpers.getConfig("config/dbconfig.prop");
    }

    public DAO(String table) {
        connection = MariadbConnection.getInstance();
        this.table = table;
    }

    protected abstract T createObject(ResultSet rs) throws SQLException;

    protected abstract void create(T obj);

    protected abstract void update(T obj);

    public void save(T obj) {
        if (obj.getId() == null) {
            create(obj);
        } else {
            update(obj);
        }

    }

    public T read(Integer id) {
        T obj = null;
        String sql = "SELECT * FROM " + table + " WHERE id= ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.first()) {
                obj = createObject(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, "Erreur lors de la lecture : " + ex.getMessage());
        }
        return obj;
    }

    public void delete(Integer id) {
        String sql = "DELETE FROM " + table + " WHERE id=?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql);) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, "Erreur lors du delete : " + ex.getMessage());
        }
    }

    public int count() {
        int count = 0;
        String sql = "SELECT COUNT(*) AS c FROM " + table;
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            if (rs.first()) {
                count = rs.getInt("c");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, "Erreur lors du comptage : " + ex.getMessage());
        }
        return count;
    }

    public Collection<T> list() {
        ArrayList<T> list = new ArrayList<>();
        String sql = "SELECT * FROM " + table;
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                T obj = createObject(rs);
                list.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, "Erreur lors du listage : " + ex.getMessage());
        }
        return list;
    }

}