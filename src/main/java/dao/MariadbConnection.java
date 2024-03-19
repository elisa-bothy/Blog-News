/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Guillaume Rostagnat
 */
public class MariadbConnection {
    
    private static Connection connection;

    private MariadbConnection() {
    }
    /**
     * Retourne un singleton de connexion.
     *
     * @return un objet Connection vers la DB
     */
    public static Connection getInstance() {
        if (connection == null) {
            String url = String.format(
                    "%s://%s:%s/%s",
                    "jdbc:mariadb",
                    "wp.ldnr.fr",
                    "3306",
                    "cda202302_jee4"
            );
            try {
                // après avoir ajouté le driver MariaDB en dépendance du projet
                // on force le chargement de la classe driver
                // non obligatoire en JSE 6+ mais nécessaire en JEE !
                Class.forName("org.mariadb.jdbc.Driver");
                connection = DriverManager.getConnection(url, "cda202302_jee4", "Charybde2024");
            } catch (SQLException ex) {
                Logger.getLogger(MariadbConnection.class.getName()).log(Level.SEVERE, null, ex);
                System.exit(2);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MariadbConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            Logger.getLogger(MariadbConnection.class.getName()).log(Level.INFO, "Fermeture de la connexion.");
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(MariadbConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

    

