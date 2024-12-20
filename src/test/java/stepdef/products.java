package stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;


public class products {

    public RequestSpecification httpRequest;
    public Response response;
    public int ResponseCode;

    public ResponseBody body;
    public JSONObject params;

    @When("^GET The (.*) Request$")
    public void hitTheUrl(String endpoint) {

        httpRequest = RestAssured.given();
        response = httpRequest.get(endpoint);
//        System.out.println(response.asString());
    }

    @Then("^verify value of the (.*) is equals with (.*)$")
    public void verifyTheParameterData(String path, String cat) {

        JsonPath jsnpath = response.jsonPath();
        String exptd = jsnpath.getJsonObject(path).toString();
        assertEquals(cat, exptd);
    }

    @Then("Verify the response code is (.*)$")
    public void getTheCode(int code) {

        ResponseCode = response.getStatusCode();
        assertEquals(ResponseCode, code);
    }

    @Given("^Pointing The URL (.*)$")
    public void hitTheApiWithPostCondition(String url) {

        RestAssured.baseURI = url;
    }

    @Given("^Create Product data Payload with title (.*)")
    public void hitTheApiWithPostConditionToCreateTheValue(String data) {

        httpRequest = given();
        params = new JSONObject();
        params.put("title", data);
        params.put("price", 20);
        params.put("description", "testing description");
        params.put("image", "google.com");
        params.put("category", "clothes");
    }
    @Given("^POST (.*) The Request$")
    public void postTheRequest(String endpoint){
        httpRequest.body(params.toJSONString());
        response = httpRequest.post(endpoint);
        body = response.getBody();
        System.out.println(response.asString());
    }

}