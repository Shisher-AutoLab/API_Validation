package Utility;

import org.json.JSONArray;
import org.json.JSONObject;

public class Helper {

	public static JSONObject responcejson;
	// static Object obj;

	public static String getValueByJSONPath(JSONObject responcejson, String JSONPath) {

		Object obj = responcejson;
		for (String s : JSONPath.split("/"))
			if (!s.isEmpty())
				obj = ((JSONObject) obj).get(s);
			else if (s.contains("[") || s.contains("]"))
				obj = ((JSONArray) ((JSONObject) obj).get(s.split("\\[")[0]))
						.get(Integer.parseInt(s.split("\\[")[1].replace("]", "")));
		return obj.toString();
	}

}
