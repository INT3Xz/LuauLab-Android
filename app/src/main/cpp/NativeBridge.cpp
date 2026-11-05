#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jstring JNICALL
Java_com_luau_lab_runtime_NativeBridge_engineVersion(
        JNIEnv* env,
        jobject /* this */) {
    const std::string version =
        "Luau Lab native bridge 0.1.0 (Luau engine integration pending)";
    return env->NewStringUTF(version.c_str());
}
