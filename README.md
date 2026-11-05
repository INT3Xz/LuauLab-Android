# Luau Lab

An open-source Luau development environment for Android.

## Vision

Luau Lab aims to provide an Android-first environment for editing Luau,
running supported Luau code locally, and designing independent Roblox-inspired
UI simulations.

This project is not a Roblox executor or injector and does not interact with
the Roblox client.

## Current status

- [x] Android project foundation
- [x] Jetpack Compose starter interface
- [x] C++ / JNI bridge foundation
- [ ] Official Luau runtime integration
- [ ] Code editor language services
- [ ] GUI component simulator
- [ ] Project import/export
- [ ] Automated tests

Features are marked complete only after implementation and verification.

## Technology

- Kotlin
- Jetpack Compose
- C++17
- JNI
- CMake
- Gradle

## Build

Open the project in Android Studio with Android SDK 35, NDK and CMake installed.
Use the included GitHub Actions workflow for cloud APK builds.

## License

MIT for original project code. Third-party components retain their own licenses.
