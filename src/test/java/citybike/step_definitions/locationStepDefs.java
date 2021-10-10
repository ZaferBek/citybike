package citybike.step_definitions;

import citybike.utils.apiUtils;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import org.junit.Assert;

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

    @Then("verify that the city {string} is in country {string}")
    public void verify_that_the_city_is_in_country(String city, String country) {
        apiUtils.verifyCountry(city, country);
        System.out.println(city + " is in " + country);
    }
    @Then("return latitude and longitude of {string}")
    public void return_latitude_and_longitude_of(String city) {
        System.out.println(city+" latitude: "+apiUtils.latitudeLongitude(city).get("latitude"));
        System.out.println(city+" longitude: "+apiUtils.latitudeLongitude(city).get("longitude"));
    }

}
