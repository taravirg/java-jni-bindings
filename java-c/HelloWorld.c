 #include <jni.h>
 #include <stdio.h>
 #include "HelloWorld.h"

 JNIEXPORT void JNICALL 
 Java_HelloWorld_hello(JNIEnv *env, jobject obj)
 {
     printf("Hello World from the C land!\n");
     return;
 }