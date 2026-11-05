package com.luau.lab.runtime

object NativeBridge {
    init {
        System.loadLibrary("luaulab")
    }

    external fun engineVersion(): String
}
