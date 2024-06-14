use jni::JNIEnv;
use jni::objects::{JClass, JString};

#[no_mangle]
pub extern "system" fn Java_HelloWorld_hello(env: JNIEnv, _class: JClass) {
    println!("Hello from the Rust world!");
}