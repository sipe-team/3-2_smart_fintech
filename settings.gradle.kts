rootProject.name = "fintech"

pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    @Suppress("UnstableApiUsage")
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

include(
    "api",
    "common",
    "account",
    "wallet",
    "payment",
    "transfer"
)
