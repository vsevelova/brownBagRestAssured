package simpleDeleteTest;

import baseclass.BaseClass;
import io.restassured.http.Method;
import org.testng.Assert;
import org.testng.annotations.Test;

public class simpleDeleteTest extends BaseClass {



    @Test
    void requestToServer() {
        response = httpRequest.request(Method.DELETE, properties.getProperty("basePath"));
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 404);

    }




}
