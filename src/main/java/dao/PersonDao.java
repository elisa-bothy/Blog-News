package dao;

import entities.Person;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author stag
 */
public class PersonDao extends DAO<Person> {

    public PersonDao() {
        super("person");
    }

    @Override
    protected Person createObject(ResultSet rs) throws SQLException {
        Person obj = new Person();
        obj.setId(rs.getInt("id"));
        obj.setLogin(rs.getString("login"));
        obj.setActive(rs.getBoolean("active"));
        obj.setPassword(rs.getString("password"));

        return obj;

    }

    @Override
    protected void create(Person obj) {
        String sql = "INSERT INTO " + table + " (login, password) VALUES (?, ?)";
        try ( PreparedStatement pstmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, obj.getLogin());
            pstmt.setString(2, obj.getPassword());
            int nbLines = pstmt.executeUpdate();
            if (nbLines == 1) {
                ResultSet generatedKeys = pstmt.getGeneratedKeys();
                generatedKeys.first();
                int id = generatedKeys.getInt(1);
                obj.setId(id);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void update(Person obj) {
        String sql = "UPDATE " + table
                + " SET login=?, password=?, active=? WHERE id=?";
        try ( PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, obj.getLogin());
            pstmt.setString(2, obj.getPassword());
            pstmt.setBoolean(3, obj.getActive());
            pstmt.setInt(4, obj.getId());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PersonDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Person read(String login) {
        Person obj = null;
        String sql = "SELECT * FROM " + table + " WHERE login=?";
        try ( PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, login);
            ResultSet rs = pstmt.executeQuery();
            if (rs.first()) {
                obj = createObject(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, "Erreur lors de la lecture : {0}", ex.getMessage());
        }
        return obj;
    }



}
