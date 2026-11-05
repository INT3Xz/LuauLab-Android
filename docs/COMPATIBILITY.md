# Compatibility

Luau language support and Roblox API compatibility are separate concerns.

The project intends to embed the official Luau runtime. Roblox-specific APIs
will only be available through explicitly implemented independent simulations.
Luau Lab does not inject into or execute code inside the Roblox client.
