plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.kotlin.spring)
    alias(libs.plugins.kotlin.jpa)
    alias(libs.plugins.spring.boot)
    alias(libs.plugins.spring.dependency.management)
    alias(libs.plugins.ktlint)
}

ktlint {
    version.set(libs.versions.ktlint.version.set)
}

version = project.findProperty("applicationVersion")?.toString() ?: "0.0.1-SNAPSHOT"
group = project.findProperty("projectGroup")?.toString() ?: "com.example"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    // Spring
    implementation(libs.spring.boot.starter.web)
    implementation(libs.spring.boot.starter.data.jpa)
    implementation(libs.spring.boot.starter.data.jdbc)
    implementation(libs.spring.boot.starter.actuator)

    // Spring Modulith (bundle 사용)
    implementation(libs.bundles.spring.modulith)
    runtimeOnly(libs.bundles.spring.modulith.runtime)

    // Libraries
    implementation(libs.jackson.kotlin)
    implementation(libs.kotlin.reflect)

    implementation(libs.java.dotenv)

    // Database
    runtimeOnly(libs.postgresql)
    runtimeOnly(libs.h2)

    // Test
    testImplementation(libs.spring.boot.starter.test)
    testImplementation(libs.kotlin.test.junit5)
    testRuntimeOnly(libs.junit.platform)

    // API Docs
    implementation(libs.spring.doc.openapi.starter.webmvc.ui)
}

dependencyManagement {
    imports {
        mavenBom(
            libs.spring.modulith.bom
                .get()
                .toString(),
        )
    }
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

tasks.register("addLintPreCommitHook", DefaultTask::class) {
    group = "setup"
    description = "Install git hooks"
    doLast {
        val hooksDir = project.file(".git/hooks")
        val scriptDir = project.file("scripts")
        val preCommit = scriptDir.resolve("pre-commit")
        Runtime.getRuntime().exec("chmod +x .git/hooks/pre-commit")
        preCommit.copyTo(hooksDir.resolve("pre-commit"), overwrite = true)
        hooksDir.resolve("pre-commit").setExecutable(true)
    }
}

tasks.named("compileKotlin") {
    dependsOn("addLintPreCommitHook")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
