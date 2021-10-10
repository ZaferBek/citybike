package citybike.step_definitions;

import citybike.pojo.Root;
import citybike.utils.apiUtils;
import io.cucumber.java.en.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;

import java.util.Map;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;

public class locationStepDefs {
    Response response;
    @When("user sends get request to endpoint")
    public void user_sends_get_request_to_endpoint() {
        String uri="http://api.citybik.es/v2/networks";
        response= apiUtils.getRequest(uri);
    }
    @Then("verify that respond status code is {int} and content-type is {string}")
    public void verify_that_respond_status_code_is_and_content_type_is(int statusCode, String contentType) {
        Assert.assertEquals(statusCode,response.statusCode());
        Assert.assertEquals(contentType, response.contentType());
    }
    Root root;
    @Then("verify that the city {string} is in country {string}")
    public void verify_that_the_city_is_in_country(String city, String country) {
//        root=apiUtils.getRoot();
//        System.out.println(root.getNetworks()[0].getLocation().getCity());
        JsonPath jsonPath = response.jsonPath();
        System.out.println(jsonPath.getString("network[1].location.city"));
//        json.body("network[1].location.city", equalTo("Frankfurt"));
//        json.body("network[1].location.country", equalTo("DE"));
        System.out.println("working");
    }
    @Then("verify latitude and longitude of the city")
    public void verify_latitude_and_longitude_of_the_city() {

    }

    private ValidatableResponse json;
    private RequestSpecification request;

    //@And("^response includes the following$")
    public void response_equals(Map<String,String> responseFields){
        for (Map.Entry<String, String> field : responseFields.entrySet()) {
            if(StringUtils.isNumeric(field.getValue())){
                json.body(field.getKey(), equalTo(Integer.parseInt(field.getValue())));
            }
            else{
                json.body(field.getKey(), equalTo(field.getValue()));
            }
        }
    }

    //@And("^response includes the following in any order$")
    public void response_contains_in_any_order(Map<String,String> responseFields){
        for (Map.Entry<String, String> field : responseFields.entrySet()) {
            if(StringUtils.isNumeric(field.getValue())){
                json.body(field.getKey(), containsInAnyOrder(Integer.parseInt(field.getValue())));
            }
            else{
                json.body(field.getKey(), containsInAnyOrder(field.getValue()));
            }
        }
    }
}
