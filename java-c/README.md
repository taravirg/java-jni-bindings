# Java - C JNI Binder

A simple binder to use C code inside of a Java class.

This was based off a tutorial here:
https://web.archive.org/web/20120419230023/http://java.sun.com/docs/books/jni/html/start.html

## Using Windows

To run your Java 'HelloWorld' class with a native C method, simply compile your HelloWorld.c file:

`cl -I{JAVA_HOME}\include -I{JAVA_HOME}\include\win32 -MD -LD HelloWorld.c -FeHelloWorld.dll`

Compile your Java HelloWorld.java class:

`javac HelloWorld.java`

Add a header file:

`javac -h . HelloWorld.java`

And run your java file, with a native C method:

`java HelloWorld`