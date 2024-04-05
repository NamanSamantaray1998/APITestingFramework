package apiTestingFrameWork.APIsStripeAPI;

import static io.restassured.RestAssured.given;

import java.util.Hashtable;

import apiTestingFrameWork.SetUpStripeAPI.BaseTest;
import io.restassured.response.Response;

public class DeleteCustomerAPI extends BaseTest {
	public static Response sendDeleteRequestToDeleteCustomerAPIWithValidId(Hashtable<String, String> data) {

		Response response = given().auth().basic(config.getProperty("validSecretKey"), "")
				.delete(config.getProperty("customerAPIEndPoint")+"/"+data.get("id"));
		return response;
	}

}
