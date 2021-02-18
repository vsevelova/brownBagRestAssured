package simpleGetTest;

import baseclass.BaseClass;
import io.restassured.http.Method;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetSingleUser extends BaseClass {

    @Test
    void requestToServer()
    {
        response = httpRequest.request(Method.GET, properties.getProperty("getSingelEmployeeData"));
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200);
    }

    @Test
    void responseUserValidation()
    {
        String responseBody = response.getBody().prettyPrint();
        System.out.println(responseBody);
        Assert.assertTrue(responseBody.contains("Pig"));
    }
}
