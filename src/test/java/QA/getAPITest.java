package QA;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import TestBase.MainBase;
import TestBase.RestClient;

public class getAPITest extends MainBase {

	MainBase mainBase;
	String serviceURL;
	String apiURL;
	String URL;

	@BeforeClass
	public void setup() {

		mainBase = new MainBase();
		serviceURL = prop.getProperty("URL");
		apiURL = prop.getProperty("serviceURL");
		URL = serviceURL + apiURL;

	}

	@Test
	public void validateGet() {
		try {

			RestClient restclient = new RestClient();
			restclient.get(URL);

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
