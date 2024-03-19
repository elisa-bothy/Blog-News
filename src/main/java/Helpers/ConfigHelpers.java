package Helpers;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Herbert Caffarel
 */
public final class ConfigHelpers {

    private ConfigHelpers() {
    }

    public static Properties getConfig(String path) {
        Properties p = new Properties();
        try (InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(path)) {
            p.load(is);
        } catch (IOException ex) {
            Logger.getLogger(ConfigHelpers.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(
                    null,
                    "Impossible de récupérer les données de configuration.\n"
                    + "Vérifiez votre fichier de configuration dans "
                    + path,
                    "Une erreur est survenue",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
        return p;
    }


}
