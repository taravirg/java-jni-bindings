public class HelloWorld {
    private native void hello();

    static {
        System.loadLibrary("HelloWorld");
        System.out.println("Successfully loaded native C library!");
    }

    // The rest is just regular ol' Java!
    public static void main(String[] args) {
        new HelloWorld().hello();
    }
}