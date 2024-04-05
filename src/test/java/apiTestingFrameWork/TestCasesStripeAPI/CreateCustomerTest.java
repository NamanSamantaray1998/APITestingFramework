package apiTestingFrameWork.TestCasesStripeAPI;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.util.Hashtable;

import org.testng.annotations.Test;

import apiTestingFrameWork.APIsStripeAPI.CreateCustomerAPI;
import apiTestingFrameWork.ListenersStripeAPI.ExtentListeners;
import apiTestingFrameWork.SetUpStripeAPI.BaseTest;
import apiTestingFrameWork.UtilitiesStripeAPI.DataUtil;
import io.restassured.response.Response;

public class CreateCustomerTest extends BaseTest {

	@Test(dataProviderClass = DataUtil.class, dataProvider = "Data")
	public void validateCreateCustomerAPIWithValidSecretKey(Hashtable<String, String> data) {

		Response response = CreateCustomerAPI.sendPostRequestToCreateCustomerAPIWithValidAuthKey(data);
		//To add customized logs
		ExtentListeners.testReport.get().info(data.toString());
		response.prettyPrint();
		System.out.println(response.statusCode());
		assertEquals(response.statusCode(), 200);
	}

	@Test(dataProviderClass = DataUtil.class, dataProvider = "Data")
	public void validateCreateCustomerAPIWithInValidSecretKey(Hashtable<String, String> data) {

		Response response = CreateCustomerAPI.sendPostRequestToCreateCustomerAPIWithInValidAuthKey(data);
		//To add customized logs
		ExtentListeners.testReport.get().info(data.toString());
		response.prettyPrint();
		System.out.println(response.statusCode());
		assertEquals(response.statusCode(), 200);

	}

}
