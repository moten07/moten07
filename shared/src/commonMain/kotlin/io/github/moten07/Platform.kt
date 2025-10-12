package io.github.moten07

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform