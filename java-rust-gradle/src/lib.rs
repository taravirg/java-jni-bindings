use jni::JNIEnv;
use jni::objects::{JClass};

#[no_mangle]
pub extern "system" fn Java_HelloWorld_hello(_env: JNIEnv, _class: JClass) {
    println!("Hello from the Rust world!");
}