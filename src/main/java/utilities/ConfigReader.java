package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private Properties property;
	
	public Properties readProperty() {
	try {
	
		FileInputStream fis = new FileInputStream("src\\test\\resources\\config\\config.properties");
		property = new Properties();
		property.load(fis);
	    }catch(FileNotFoundException e1) {
		e1.printStackTrace();
	    } catch (IOException e) {
		e.printStackTrace();
	}
	return property;
	}
	
}

