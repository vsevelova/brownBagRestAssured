package simpleGetTest;

import baseclass.BaseClass;
import io.restassured.http.Method;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleGetTest extends BaseClass {

    @Test
    void requestToServer()
    {
        response = httpRequest.request(Method.GET, properties.getProperty("wiki"));
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200);
    }
}
