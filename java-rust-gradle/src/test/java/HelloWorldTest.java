import org.junit.Test;
import org.junit.BeforeClass;
import java.nio.file.Path;
import java.nio.file.Paths;
import static org.junit.Assert.assertNotNull;

public class HelloWorldTest {

    @BeforeClass
    public static void setup() {
        System.setProperty("rustlib", "libmylib"); 
        System.setProperty("filetype", "so");
    }

    @Test
    public void testHelloMethod() {
        HelloWorld helloWorld = new HelloWorld();
        assertNotNull(helloWorld);
        
        // Since the native method 'hello' does not return any value,
        // we are just making sure it can be called without throwing an exception
        helloWorld.hello();
    }
}