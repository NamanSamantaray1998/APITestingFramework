package apiTestingFrameWork.TestCasesStripeAPI;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Hashtable;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import apiTestingFrameWork.APIsStripeAPI.DeleteCustomerAPI;
import apiTestingFrameWork.ListenersStripeAPI.ExtentListeners;
import apiTestingFrameWork.SetUpStripeAPI.BaseTest;
import apiTestingFrameWork.UtilitiesStripeAPI.DataUtil;
import apiTestingFrameWork.UtilitiesStripeAPI.TestUtil;
import io.restassured.response.Response;

public class DeleteCustomerTest extends BaseTest {

	@Test(dataProviderClass = DataUtil.class, dataProvider = "Data")
	public void deleteCustomer(Hashtable<String, String> data) {

		Response response = DeleteCustomerAPI.sendDeleteRequestToDeleteCustomerAPIWithValidId(data);
		response.prettyPrint();
		//To add customised logs
		ExtentListeners.testReport.get().info(data.toString());
		System.out.println(response.statusCode());
		
		//to get the actual id and print and check
		//String actualId=response.jsonPath().get("id").toString();
		//System.out.println("Getting id from Json path- "+actualId);
		//Assert.assertEquals(actualId, data.get("id"),"Id is not matching.");
		
//		JSONObject jsonObject= new JSONObject(response.asString());
//		System.out.println(jsonObject.has("id"));
//		assertTrue(jsonObject.has("id"), "Id key is not present in json response");
		
		//checking the presence of id key	
		System.out.println("Presence check for object key"+TestUtil.jsonHasKey(response.asString(), "object"));
		assertTrue(TestUtil.jsonHasKey(response.asString(), "id"), "Id key is not present in json response");
		
		//String actualId=jsonObject.get("id").toString();
		
		//to get the value of any key
		String actualId=TestUtil.getJsonKeyValue(response.asString(), "id");
		System.out.println(actualId);
		Assert.assertEquals(actualId, data.get("id"),"Id is not matching.");
		////to print the value of object key
		System.out.println("Object key value is- "+TestUtil.getJsonKeyValue(response.asString(), "object"));

		assertEquals(response.statusCode(), 200);
	}

	
}
