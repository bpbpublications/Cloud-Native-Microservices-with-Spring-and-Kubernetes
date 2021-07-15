package com.online.store.demo.steps.orders;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import com.online.store.demo.common.ApiEnum;
import com.online.store.demo.common.BaseTestingStep;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * Integration testing BDD Order microservices- Order Feature Steps
 *
 * @author rajiv.srivastava
 */
public class OrderFeatureSteps extends BaseTestingStep {

	@Value("${orders.host}")
	private String ordersHost;

	private static Response response;
	private static String jsonString;
	private static HttpHeaders headers;

	/*
	 * 1. Scenario: This Order microservice will call both catalogue and
	 * customer-management microservice and return aggregated result
	 */
	@Given("^I Set GET order service api endpoint$")
	public void i_Set_GET_order_service_api_endpoint() throws Throwable {
		RequestSpecification request = RestAssured.given();
		RestAssured.baseURI = ordersHost.concat(ApiEnum.ORDERS_API.value());
		request = RestAssured.given();
		request = request.headers(buildHeaders());
	}

	@When("^fetch order service will be called$")
	public void fetch_order_service_will_be_called() throws Throwable {
		RequestSpecification request = RestAssured.given();
		response = request.given().get();
	}

	@Then("^receive valid HTTP response code (\\d+)$")
	public void receive_valid_HTTP_response_code(int ok) throws Throwable {
		// Added Assert if orders is more than 0
		jsonString = response.asString();
		List<Map<String, String>> orders = JsonPath.from(jsonString).get();
		Assert.assertTrue(orders.size() > 0);

		assertThat(response.getStatusCode()).isEqualTo(ok);
	}

	@Override
	protected HttpHeaders buildHeaders() {
		headers = new HttpHeaders();
		headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
		return headers;
	}
}
