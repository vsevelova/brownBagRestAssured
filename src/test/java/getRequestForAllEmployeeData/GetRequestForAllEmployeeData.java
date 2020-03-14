package getRequestForAllEmployeeData;

import baseclass.BaseClass;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetRequestForAllEmployeeData extends BaseClass {
    //validation of status code
    // validation of status line
    // validation of Header

    @Test(priority = 1)
    void requestToServer()
    {
        response = httpRequest.request(Method.GET, properties.getProperty("getAllEmployeeData"));
    }

    @Test(priority = 2)
    void verifyStatusCode()
    {
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200);
    }

    @Test(priority = 3)
    void verifyStatusLine()
    {
        String statusLine = response.getStatusLine();
        Assert.assertEquals(statusLine, "HTTP/1.1 200 ");
    }

    @Test(priority = 4)
    void verifyResponseBody()
    {
        String responseBody = response.getBody().asString();
        Assert.assertEquals(responseBody.contains("Valentins"),true);
        JsonPath jsonPath = response.jsonPath();
        System.out.println(jsonPath.get("userName"));
    }

    @Test(priority = 5)
    void verifyHeaders()
    {
        String contentType = response.header("Content-Type");
        Assert.assertEquals(contentType,"application/json");

        String serverType = response.header("Server");
        Assert.assertEquals(serverType,"Cowboy");
    }

}
