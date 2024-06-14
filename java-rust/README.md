# Java <-> Rust JNI Binder

A simple binder to use a Rust method inside of a Java class.

This was based off a tutorial here:
https://docs.rs/jni/latest/jni/

## Running Your Java HelloWorld Class

To run your Java 'HelloWorld' class with a native Rust method, simply build your Rust library:

`cargo build`

Ensure inside your ./target/debug folder is a .so file, which is the Rust library we want to import.

Compile your Java HelloWorld.java class:

`javac HelloWorld.java`

Add a header file:

`javac -h . HelloWorld.java`

And run your java file, with an argument specifying your rustlib. If you are on Windows, it would be:

`java -Drustlib=mylib.dll HelloWorld`

And if you're on Linux:

`java -Drustlib=libmylib.so HelloWorld`