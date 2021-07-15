package com.online.store.demo.steps.orders;

import static org.assertj.core.api.Assertions.assertThat;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import com.online.store.demo.common.ApiEnum;
import com.online.store.demo.common.BaseTestingStep;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * Integration testing BDD Order microservices- Catalogue Feature Steps
 *
 * @author rajiv.srivastava
 */
public class CatalogueFeatureSteps extends BaseTestingStep {

	@Value("${catalogues.host}")
	private String cataloguesHost;

	private static Response response;
	private static String jsonString;
	private static HttpHeaders headers;

	/*
	 * 2. Scenario: This Catalogue microservice will create order
	 */

	@Given("^create catalogue data with request body \"([^\"]*)\"$")
	public void create_catalogue_data_with_request_body(String fileBody) throws Throwable {
		RestAssured.baseURI= cataloguesHost;
		
		RequestSpecification request = RestAssured.given();
		byte[] file = Files.readAllBytes(Paths.get(fileBody));
		request = request.contentType(ContentType.JSON).headers(buildHeaders()).body(file);
	}

	@When("^create  catalogues service will be called$")
	public void create_catalogues_service_will_be_called() throws Throwable {
		RequestSpecification request = RestAssured.given();
		response = request.when().post(ApiEnum.CATALOGUES_API.value());
	}

	@Then("^catalogue created with valid HTTP response code (\\d+)$")
	public void catalogue_created_with_valid_HTTP_response_code(int ok) throws Throwable {
		jsonString = response.asString();
		System.out.println(jsonString);
		assertThat(response.getStatusCode()).isEqualTo(ok);
	}

	@Override
	protected HttpHeaders buildHeaders() {
		headers = new HttpHeaders();
		headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
		return headers;
	}
}
