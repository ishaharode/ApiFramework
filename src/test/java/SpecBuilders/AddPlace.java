package SpecBuilders;

import Pojo.Location;
import Resources.TestDataBuild;
import Utilities.Utils;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class AddPlace extends Utils {
    public static String PlaceId;
    RequestSpecification Request;
    Response response;
    TestDataBuild payload = new TestDataBuild();

    public void addPlacePayload() throws IOException {
        RequestSpecification reqSpec = RequestSpecification();

        Request = given().spec(reqSpec).body(payload.AddPlacePayload());
    }
    public void addPlacePayload(String name, String language, String address) throws IOException {
        RequestSpecification reqSpec = RequestSpecification();

        Request = given().spec(reqSpec).body(payload.AddPlacePayload(name,language,address));
    }

    public void AddPlaceApi(String resource){
        ResponseSpecification resSpec = ResponseSpecification();
        response = Request.when().log().all().post(resource).then().spec(resSpec).extract().response();
    }

    public void StatusValidation(int code) {
        assertEquals(response.getStatusCode(), code);

    }

    public void ValidateResponse(String tag, String Expectedvalue) {

        if(tag.equals("status"))
        { assertEquals(getJsonPath(response,tag),Expectedvalue);}

        if(tag.equals("scope"))
        { assertEquals(getJsonPath(response,tag),Expectedvalue);}
    }
    public void capturePlaceID(){
        PlaceId =getJsonPath(response,"place_id");
        System.out.println(PlaceId);
    }

    public void GetPlaceAPI(String resource){
        ResponseSpecification resSpec = ResponseSpecification();
        PlaceId =getJsonPath(response,"place_id");
        Request = given().spec(reqSpec).queryParam("place_id",PlaceId);
        response = Request.when().log().all().get(resource).then().spec(resSpec).extract().response();
    }
    public void verifyPlaceIdCreated(String ExpectedName) throws IOException {
        assertEquals(getJsonPath(response,"name"),ExpectedName);

    }

    public void deletePlacePayload() throws IOException {
       // PlaceId =getJsonPath(response,"place_id");
        RequestSpecification reqSpec = RequestSpecification();
        Request = given().spec(reqSpec).body(payload.DeletePlacePayload(PlaceId));
    }
    public void DeletePlaceApi(String resource) throws IOException {
        ResponseSpecification resSpec = ResponseSpecification();
        response = Request.when().log().all().delete(resource).then().spec(resSpec).extract().response();
    }
}

