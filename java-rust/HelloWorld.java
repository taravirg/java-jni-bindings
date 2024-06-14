public class HelloWorld {
    // This declares that the static `hello` method will be provided
    // a native library.
    private native void hello();

    static {
        // This actually loads the shared object that we'll be creating.
        // The actual location of the .so or .dll may differ based on your
        // platform.
        System.setProperty("java.library.path", "C:\\Users\\Tara\\java-jni-bindings\\java-rust\\target\\debug");
        final Field sysPathsField = ClassLoader.class.getDeclaredField("sys_paths");
        sysPathsField.setAccessible(true);
        sysPathsField.set(null, null);
        System.out.println(System.getProperty("java.library.path"));
        System.loadLibrary("mylib");
        System.out.println("Successfully loaded native rust library!");
    }

    // The rest is just regular ol' Java!
    public static void main(String[] args) {
        new HelloWorld().hello();
    }
}