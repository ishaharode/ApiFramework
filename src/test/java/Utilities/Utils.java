package Utilities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.*;
import java.util.Properties;

public class Utils {
    //declare RequestSpecification static as it should be accessible throughout the whole execution without changing its value.
    public static RequestSpecification reqSpec;
    public RequestSpecification RequestSpecification() throws IOException {

        //need an If block to restrict the overriding of log file during the multiple run for multiple data for single scenario.
        if(reqSpec==null) {
            PrintStream log = new PrintStream(new FileOutputStream("Logging.txt"));
            reqSpec = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl")).addQueryParam("key", "qaclick123")
                    .addFilter(RequestLoggingFilter.logRequestTo(log)).addFilter(ResponseLoggingFilter.logResponseTo(log))
                    .setContentType(ContentType.JSON).build();
            return reqSpec;
        }
        return reqSpec;
    }

    public ResponseSpecification ResponseSpecification(){
        ResponseSpecification resSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
        return resSpec;
    }

    public static String getGlobalValue(String property) throws IOException {
        Properties prop = new Properties();
        FileInputStream fis;
        try {
            fis = new FileInputStream("C:\\Users\\ishah\\Workspace\\ApiTestingFramework\\src\\test\\java\\Resources\\global.properties");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            prop.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String value=prop.getProperty(property);

        return value;
    }

    public String getJsonPath(Response response, String key)
    {
        JsonPath js = new JsonPath(response.asString());
        return js.get(key).toString();
    }


}
