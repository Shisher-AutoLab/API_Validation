package TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class MainBase {

	public Properties prop;

	public MainBase() {

		try {
			prop = new Properties();
			FileInputStream fis;
			fis = new FileInputStream(
					"F:\\Shisher\\Selenium\\Workspace\\API_Validation\\Configuration\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
