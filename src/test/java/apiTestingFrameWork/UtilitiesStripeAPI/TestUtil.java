package apiTestingFrameWork.UtilitiesStripeAPI;

import org.json.JSONObject;

import apiTestingFrameWork.ListenersStripeAPI.ExtentListeners;

public class TestUtil {
	
	public static boolean jsonHasKey(String json, String key) {
		JSONObject jsonobject= new JSONObject(json);
		ExtentListeners.testReport.get().info("Validating the presence of key-"+key);
		return jsonobject.has(key);
		
		
	}
	//validating the key
	public static String getJsonKeyValue(String json, String key) {
		JSONObject jsonobject= new JSONObject(json);
		ExtentListeners.testReport.get().info("Validating value of key	"+key);
		return jsonobject.getString(key).toString();
		
		
				
	}
}
