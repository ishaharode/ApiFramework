package StepDefinitions;

import SpecBuilders.AddPlace;
import Utilities.Enums;
import io.cucumber.java.en.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.FileNotFoundException;
import java.io.IOException;

public class AddPlaceStepDef {

    AddPlace addPlace = new AddPlace();

    @Given("Add place payload with {string}, {string} and {string}")
    public void add_place_payload_with_and(String name, String language, String address) throws IOException {
        addPlace.addPlacePayload(name,language,address);
    }


    @Given("Add place payload")
    public void add_place_payload() throws IOException {
    addPlace.addPlacePayload();
    }

    @When("user calls {string} API {string} http request")
    public void user_calls_api_post_http_request(String resources,String method) throws IOException {
        //instead of if block we can use Enum class
        Enums ResourceAPI = Enums.valueOf(resources);

        if(method.equals("POST")){
            addPlace.AddPlaceApi(ResourceAPI.getResource());
        }
        else if(method.equals("GET")){
            addPlace.GetPlaceAPI(ResourceAPI.getResource());
        }
        else if(method.equals("DELETE")){
            addPlace.DeletePlaceApi(ResourceAPI.getResource());

        }

//        if(resources.equals("AddPlace"))
//        {
//            addPlace.AddPlaceApi();
//        }


    }
    @Then("API call is success with status code is {int}")
    public void api_call_is_success_with_status_code_is(int statuscode) {

        addPlace.StatusValidation(statuscode);
    }

    @Then("{string} in response body is {string}")
    public void in_response_body_is(String tag, String value) {
        addPlace.ValidateResponse(tag,value);

    }

    @Then("verify placeID created maps to {string} using {string}")
    public void verify_place_id_created_maps_to_using_get_place_api(String name,String api) throws IOException {
        user_calls_api_post_http_request(api,"GET");
        addPlace.verifyPlaceIdCreated(name);
    }

    @Given("delete Place payload")
    public void delete_Place_payload() throws IOException {
        addPlace.deletePlacePayload();

    }

}
