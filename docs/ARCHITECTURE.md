# Architecture

- `app`: Android application and Compose UI.
- `runtime`: Kotlin interface to the native runtime.
- `app/src/main/cpp`: C++ native bridge.
- `gui`: future independent UI simulation module.
- `docs`: project design and compatibility documentation.

The current native bridge is a foundation only; it does not compile or execute
Luau source code yet.
