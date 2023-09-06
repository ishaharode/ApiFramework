package Resources;

import Pojo.AddPlace;
import Pojo.Location;

import java.util.ArrayList;
import java.util.List;

public class TestDataBuild {

public AddPlace AddPlacePayload(){
    Pojo.AddPlace ap = new Pojo.AddPlace();
    ap.setAccuracy(50);
    ap.setAddress("29, side layout, cohen 09");
    ap.setLanguage("French-IN");
    ap.setName("Frontline house");
    ap.setPhone_number("(+91) 983 893 3937");
    ap.setWebsite("http://google.com");

    List<String> T = new ArrayList<String>();
    T.add("shoe park");
    T.add("shop");
    ap.setTypes(T);

    Location L = new Location();
    L.setLat(-38.383494);
    L.setLng(33.427362);
    ap.setLocation(L);
    return ap;
}


public AddPlace AddPlacePayload(String name, String language, String address){
    Pojo.AddPlace ap = new Pojo.AddPlace();
    ap.setAccuracy(50);
    ap.setAddress(address);
    ap.setLanguage(language);
    ap.setName(name);
    ap.setPhone_number("(+91) 983 893 3937");
    ap.setWebsite("http://google.com");

    List<String> T = new ArrayList<String>();
    T.add("shoe park");
    T.add("shop");
    ap.setTypes(T);

    Location L = new Location();
    L.setLat(-38.383494);
    L.setLng(33.427362);
    ap.setLocation(L);

    return ap;

}
    public String DeletePlacePayload(String placeId){
        String payload = "{\n" +
                "\t\t\"place_id\":\""+placeId+"\"\n" +
                "\t}";

        return payload;
    }
}
