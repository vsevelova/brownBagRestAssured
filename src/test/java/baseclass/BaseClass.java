package baseclass;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.BeforeClass;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {
    protected static RequestSpecification httpRequest;
    protected static Response response;
    protected Properties properties = new Properties();
    private String resoucesPath = "resources\\configuration.properties";

    @BeforeClass
    public void setUp() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(resoucesPath));
        properties.load(reader);
        RestAssured.baseURI = properties.getProperty("baseURL");
        httpRequest = RestAssured.given();
    }
}
