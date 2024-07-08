package utilities;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;
import java.util.logging.Level;

public class PropertiesReader 
{
	 private final Properties properties;
	    private final String filePath;
	    private static final Logger LOGGER = Logger.getLogger(PropertiesReader.class.getName());

	    public PropertiesReader(String filePath) {
	        this.filePath = filePath;
	        this.properties = new Properties();
	        loadProperties();
	    }

	    private synchronized void loadProperties() {
	        try (FileInputStream inStream = new FileInputStream(filePath)) {
	            properties.load(inStream);
	        } catch (IOException e) {
	            LOGGER.log(Level.SEVERE, "Failed to load properties", e);
	        }
	    }

	    public synchronized String getProperty(String key) {
	        return properties.getProperty(key);
	    }

	    public synchronized void setProperty(String key, String value) {
	        properties.setProperty(key, value);
	        saveProperties();
	    }

	    private synchronized void saveProperties() {
	        try (FileOutputStream outStream = new FileOutputStream(filePath)) {
	            properties.store(outStream, null);
	        } catch (IOException e) {
	            LOGGER.log(Level.SEVERE, "Failed to save properties", e);
	        }
	    }

}
