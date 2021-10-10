package citybike.utils;

import io.restassured.response.Response;
import java.util.List;
import java.util.Map;
import static io.restassured.RestAssured.*;

public class apiUtils {

    public static Response response;
    public static Response getRequest(String uri){
        response = given().get(uri);
        return response;
    }

    public static boolean verifyCountry(String city, String country){
        Map<String,Object> root=response.body().as(Map.class);
        List<Map<String,Object>> networks= (List<Map<String, Object>>) root.get("networks");
            boolean dummy=false;
        for(int i=0; i<networks.size(); i++){
            if(((Map<?, ?>) networks.get(i).get("location")).equals(city)) {
                Map<String, Object> location1 = (Map<String, Object>) networks.get(i).get("location");
                dummy= location1.get("country").equals(country);
            }
        }return dummy;
    }

    public static Map<String,Object> latitudeLongitude(String city){
        Map<String,Object> root=response.body().as(Map.class);
        List<Map<String,Object>> networks= (List<Map<String, Object>>) root.get("networks");
        Map <String,Object> location1 = null;
        for(int i=0; i<networks.size(); i++){
            if(((Map<?, ?>) networks.get(i).get("location")).containsValue(city)) {
                location1 = (Map<String, Object>) networks.get(i).get("location");
            }
        }return location1;
    }
}
