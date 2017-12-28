import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class ReadDataFromProperties {
	 Properties prop = new Properties();
	 public static WebDriver driver;
		public void ReadDataProp(){
	
		File file = new File("F:/Selenium/01/Global.properties");
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} 
		catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		//load properties file
		try {
			prop.load(fileInput);
		}
		catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		Enumeration KeyValues = prop.keys();
		while (KeyValues.hasMoreElements()) {
			String key = (String) KeyValues.nextElement();
			String value = prop.getProperty(key);
			System.out.println(key + ":- " + value);
		}
		
	}
}
