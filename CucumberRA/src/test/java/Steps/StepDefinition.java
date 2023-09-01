package Steps;

import java.io.File;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class StepDefinition {

	public static RequestSpecification inputrequest;
	public static Response response;
	public static String sys_id;
	
	@Given("Set Base URI")
	public void setbase() {
		
		RestAssured.baseURI="https://dev170112.service-now.com/api/now/table";
	}
	
	@And("Set Auth")
	public void setaut() {
		RestAssured.authentication=RestAssured.basic("admin","crT7f!Y7QrK%");
	}
	
	@When("Create incident with body {string}")
	public void createincidentwithbody(String body) {
		inputrequest = RestAssured.given().contentType("application/json").when().body(body);
		
		//send the requests
		 response = inputrequest.post("/incident");
	}
	@Then("Validate response code as {int}")
	public void validateresponsecode(int statuscode) {
		response.then().assertThat().statusCode(statuscode);
	}
	
	@When("get incidents with queryparam {string} and {string}")
	public void getincidentwithqueryparam(String key,String value) {
		inputrequest = RestAssured.given().queryParam(key, value);
		 response=inputrequest.get("/incident");
	}
	
	
	
	@When ("create incident with {string}")
	public void createincidentwithfile(String fileName){
	File filepath =new File("C:/Users/KathirNimi/Desktop/Testing/RESTAPI_course_Testleaf/Restassured/CucumberRA/src/test/resources/"+fileName);
	inputrequest =RestAssured.given().contentType("application/json").when().body(filepath);
	response=inputrequest.post("/incident");
	sys_id=response.jsonPath().get("result.sys_id");

	System.out.println("sys idd---------"+sys_id);
	}
	
	@When("update incident with body {string}")
	public void updateIncidentWithBody(String body) {
		
		 inputrequest = RestAssured.given().contentType("application/json").when().body(body);
		 response = inputrequest.put("/incident/"+sys_id);	 
		 response.prettyPrint();
		 System.out.println("sys idd---------"+sys_id);
	}
	
	
}