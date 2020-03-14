package baseclass;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {
    public static RequestSpecification httpRequest;
    public static Response response;
    public Properties properties = new Properties();
    public String resoucesPath = "resources\\configuration.properties";

    @BeforeClass
    public void setUp() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(resoucesPath));
        properties.load(reader);
        RestAssured.baseURI = properties.getProperty("baseURL");
        httpRequest = RestAssured.given();

    }
}
