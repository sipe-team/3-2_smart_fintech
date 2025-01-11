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
    "account",
    "wallet",
    "payment",
    "transfer"
)
