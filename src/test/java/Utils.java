import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import java.util.Properties;

public class Utils {

    // Config.properties e json value token save.
    public static void setEnvVariable(String key, String Value) throws ConfigurationException {
        PropertiesConfiguration config = new PropertiesConfiguration("./src/test/resources/config.properties");
        config.setProperty(key, Value);
        config.save();
    }
}
