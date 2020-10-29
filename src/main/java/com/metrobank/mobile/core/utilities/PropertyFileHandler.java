/**
 * 
 */
package main.java.com.metrobank.mobile.core.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Description
 * this class contains methods for handling
 * property class
 *
 */
public class PropertyFileHandler {

	private final Properties properties;
	private String path;
	private String userDirectory;
	
	public PropertyFileHandler (String path) {
		this.properties = new Properties();
		this.path = path;
		
		Load();
	}
	
	public void Load() {
		FileInputStream fis = null;
		try {
			// Get working directory path
			userDirectory = System.getProperty("user.dir");
			// Combine user directory and file path
			fis = new FileInputStream(userDirectory + path);
			properties.load(fis);
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public String GetValue(String key) {
		return properties.getProperty(key);
	}
}
