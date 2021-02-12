import baseclass.BaseClass;
import io.restassured.http.Method;
import junit.framework.Assert;
import org.testng.annotations.Test;

public class DeleteData extends BaseClass {
    @Test
    void deleteData() {
        response = httpRequest.request(Method.DELETE, properties.getProperty("basePath"));
        int statusCode = response.getStatusCode();
        Assert.assertEquals(204, statusCode);
    }
}
