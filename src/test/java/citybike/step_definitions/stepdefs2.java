package citybike.step_definitions;


        import static io.restassured.RestAssured.defaultParser;
        import static io.restassured.RestAssured.given;
        import static org.hamcrest.Matchers.containsInAnyOrder;
        import static org.hamcrest.Matchers.equalTo;

        import java.util.HashMap;
        import java.util.Map;

        import io.cucumber.java.en.*;
        import org.apache.commons.lang3.StringUtils;

        import io.restassured.response.Response;
        import io.restassured.response.ValidatableResponse;
        import io.restassured.specification.RequestSpecification;

public class stepdefs2 {
    private Response response;
    private ValidatableResponse json;
    private RequestSpecification request;

    private String ENDPOINT_GET_CITYBIKES_BY_COUNTRIES = "http://api.citybik.es/v2/networks";

    @Given("^a city bike exist within a company$")
    public void GetEndpoint(){
        request = given().header("Accept", "application/json");
    }

    @When("^a user retrieves the city by location$")
    public void a_user_retrieves_the_city_by_location(){
        response = request.when().get(ENDPOINT_GET_CITYBIKES_BY_COUNTRIES);
        //System.out.println("response: " + response.prettyPrint());
    }

    @Then("^the status code is (\\d+)$")
    public void verify_status_code(int statusCode){
        json = response.then().statusCode(statusCode);
    }
    @And("^response includes the following$")
    public void response_equals(Map<String,String> responseFieldss) {
        Map<String, String> responseFields = new HashMap<>();
        for (int i = 0; i <= 400; i++) {

            boolean bool = true;
            responseFields.put("networks[" + i + "].location.city", "Frankfurt");
            responseFields.put("networks[" + i + "].location.country", "DE");

//        for (Map.Entry<String, String> field : responseFields.entrySet()) {
//           if(StringUtils.isNumeric(field.getValue())){
//               json.body(field.getKey(), equalTo(Integer.parseInt(field.getValue())));
//            }
//            else{
            try {
                json.body("networks[" + i + "].location.city", equalTo("Frankfurt"));
            } catch (Exception e) {
                bool = false;
            }
            if (bool) {
                json.body("networks[" + i + "].location.country", equalTo("DE"));
                break;
            }
//            }
//        }
        }}

        @And("^response includes the following in any order$")
        public void response_contains_in_any_order (Map < String, String > responseFields){
            for (Map.Entry<String, String> field : responseFields.entrySet()) {
                if (StringUtils.isNumeric(field.getValue())) {
                    json.body(field.getKey(), containsInAnyOrder(Integer.parseInt(field.getValue())));
                } else {
                    json.body(field.getKey(), containsInAnyOrder(field.getValue()));
                }
            }
        }
    }