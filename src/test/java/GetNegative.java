import baseclass.BaseClass;
import io.restassured.http.Method;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetNegative extends BaseClass {
    @Test
    void requestToServer()
    {
        response = httpRequest.request(Method.GET, properties.getProperty("getUserNegative"));
        int statusCode = response.getStatusCode();
        Assert.assertNotEquals(statusCode,200);
    }
}
