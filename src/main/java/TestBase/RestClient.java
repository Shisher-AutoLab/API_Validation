package TestBase;

import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import Utility.Helper;

public class RestClient {
	
	
	
	//Get method
	
	public void get(String URL) {
		try {
			
			CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpGet httpget = new HttpGet(URL);
			
			//status code
			CloseableHttpResponse closablehttpResponse = httpclient.execute(httpget); // this will have all the  ethods
			int statusCode = closablehttpResponse.getStatusLine().getStatusCode();
			
			if(statusCode==200) {
			System.out.println("Status code " +statusCode);
			} else {
				System.out.println("Status code is not 200 and it it " +statusCode);
			}
			
			
			//JSON string
			String strresponce = EntityUtils.toString(closablehttpResponse.getEntity(), "UTF-8");
			
			JSONObject JSONresponse  = new JSONObject(strresponce);
			System.out.println("JSON responce " +JSONresponse);
			
			String perpage = Helper.getValueByJSONPath(JSONresponse,"/per_page");
			System.out.println("------------->" +perpage);
			
			
			// all headers
			Header[] headerArray =  closablehttpResponse.getAllHeaders();
			HashMap<String, String> allheaders = new HashMap<String, String>();
			
			for (Header header : headerArray) {
				allheaders.put(header.getName(), header.getValue());
				
			}
			
			System.out.println("Headers " +allheaders);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	

}
