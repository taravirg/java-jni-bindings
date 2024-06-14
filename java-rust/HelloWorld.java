import java.nio.file.Path;
import java.nio.file.Paths;

public class HelloWorld {
    // This declares that the static `hello` method will be provided
    // a native library.
    private native void hello();

    static {
        Path p = Paths.get(String.format("target/debug/%s", System.getProperty("rustlib")));
        System.load(p.toAbsolutePath().toString());
        System.out.println("Successfully loaded native rust library!");
    }

    // The rest is just regular ol' Java!
    public static void main(String[] args) {
        new HelloWorld().hello();
    }
}