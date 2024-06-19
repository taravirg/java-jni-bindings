import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.StandardCopyOption;

public class HelloWorld {
    // This declares that the static `hello` method will be provided
    // a native library.
    protected native void hello();

    static {
        try {
            // Extract the library to a temporary directory
            Path temp = extractLibraryFile(String.format("lib/%s.%s", System.getProperty("rustlib"), System.getProperty("filetype")));

            // Load the library
            System.load(temp.toAbsolutePath().toString());
            System.out.println("Successfully loaded native rust library!");
        } catch (IOException e) {
            throw new RuntimeException("Failed to extract and load the library", e);
        }
    }

    // The rest is just regular ol' Java!
    public static void main(String[] args) {
        new HelloWorld().hello();
    
    }

     /**
     * We are extracting the resource shared library file and storing it in /tmp on the local
     * file system.
     *
     * If you'd like to learn more about this please read up on
     * <a href="https://animallogic.atlassian.net/wiki/spaces/~josephtr/blog/2024/06/18/14982488817723/Episode+MOD-1003+-+what+on+earth+is+a+JNI">...</a>
     * @param libPath, the path to the shared library file within the resources directory
     * @return a Path object
     * @throws IOException
     */
    private static Path extractLibraryFile(String libPath) throws IOException {
        try (InputStream inputStream = HelloWorld.class.getResourceAsStream("/" + libPath)) {
            if (inputStream == null) {
                throw new IOException("Library " + libPath + " not found in JAR.");
            }

            Path tempFile = Files.createTempFile(System.getProperty("rustlib"), String.format(".%s", System.getProperty("filetype")));
            tempFile.toFile().deleteOnExit();

            Files.copy(inputStream, tempFile, StandardCopyOption.REPLACE_EXISTING);

            return tempFile;
        }
    }
}