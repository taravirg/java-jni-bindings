# Java <-> Rust JNI Binder, but Running with a jar build by Gradle

A simple binder to use a Rust method inside of a Java class. This folder uses gradle to build your Java script into a jar to be run.

This was based off a tutorial here:
https://docs.rs/jni/latest/jni/

## Running Your Java HelloWorld Class

The buildscript does everything for you, including the `cargo build` required to build the rust code.
Thus, all you need to do is run a 

`gradle build`

and you should see your jar in `build/libs`. Note that if you unpack the jar, you'll see that your library file was copied over
into the resources/lib directory. This will be unpacked & copied over to /tmp to be used by the jar.

Once you've found your jar, you can run on Linux with:

`java -Drustlib=libmylib -Dfiletype=so -jar build/libs/java-rust-gradle-{version}.jar`