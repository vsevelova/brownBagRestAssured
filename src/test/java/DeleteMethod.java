import baseclass.BaseClass;
import io.restassured.http.Method;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteMethod extends BaseClass {

    @Test
    void DeleteUser()
    {
        response = httpRequest.request(Method.DELETE, properties.getProperty("basePath"));
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,204);
    }
}
