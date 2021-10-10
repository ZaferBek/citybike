package citybike.utils;

import citybike.pojo.Root;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class apiUtils {

    public static Response response;
    public static Response getRequest(String uri){
        response = given().get(uri);
        return response;
    }

    public static Root getRoot(){
        Root root= response.body().as(Root.class);
        return root;
    }

}
