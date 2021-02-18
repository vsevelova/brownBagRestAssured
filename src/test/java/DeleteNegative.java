import baseclass.BaseClass;
import io.restassured.http.Method;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteNegative extends BaseClass {
    @Test
    void DeleteNegative()
    {
        response = httpRequest.request(Method.DELETE, properties.getProperty("basePathNeg"));
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,404);
    }
}
