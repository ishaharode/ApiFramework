package StepDefinitions;


import SpecBuilders.AddPlace;
import io.cucumber.java.Before;
import io.cucumber.messages.types.StepDefinition;

import java.io.IOException;

public class Hooks {
    @Before("@deletePlace")
    public void beforeScenario() throws IOException {
        //code to get the place_id
        //run only when the place id is null
        AddPlace addPlace = new AddPlace();
        AddPlaceStepDef m = new AddPlaceStepDef();
        if(addPlace.PlaceId==null)
        {
            //addPlace.addPlacePayload("whiteHouse", "Hindi", "NewDelhi");
            m.add_place_payload_with_and("whiteHouse", "Hindi", "NewDelhi");
            m.user_calls_api_post_http_request("addPlaceAPI", "POST");
            m.verify_place_id_created_maps_to_using_get_place_api("whiteHouse","getPlaceAPI");

        }

    }
}
