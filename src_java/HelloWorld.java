public class HelloWorld {
    // This declares that the static `hello` method will be provided
    // a native library.
    private static native String hello(String input);

    static {
        // This actually loads the shared object that we'll be creating.
        // The actual location of the .so or .dll may differ based on your
        // platform.
        System.out.println("Loading rust lib!");
        System.loadLibrary("rust-jni-ex");
    }

    // The rest is just regular ol' Java!
    public static void main(String[] args) {
        System.out.println("We have begun..");
        String output = HelloWorld.hello("josh");
        System.out.println(output);
    }
}