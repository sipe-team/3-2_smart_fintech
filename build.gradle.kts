plugins {
    kotlin("jvm") version "2.1.0"
    kotlin("plugin.spring") version "2.1.0"
    kotlin("plugin.jpa") version "2.1.0"
    id("org.springframework.boot") version "3.4.1"
    id("io.spring.dependency-management") version "1.1.7"
    id("org.jlleitschuh.gradle.ktlint") version "12.1.2"
}

ktlint {
    version.set("1.5.0")
}

version = "${property("applicationVersion")}"
group = "${property("projectGroup")}"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

extra["springModulithVersion"] = "1.3.1"

repositories {
    mavenCentral()
}

dependencies {
    // spring
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
//    implementation("org.springframework.kafka:spring-kafka")

    // spring-modulith
    implementation("org.springframework.modulith:spring-modulith-events-api")
    implementation("org.springframework.modulith:spring-modulith-starter-core")
    implementation("org.springframework.modulith:spring-modulith-starter-jdbc")
    implementation("org.springframework.modulith:spring-modulith-test")

    runtimeOnly("org.springframework.modulith:spring-modulith-actuator")
    runtimeOnly("org.springframework.modulith:spring-modulith-events-kafka")
    runtimeOnly("org.springframework.modulith:spring-modulith-observability")
    runtimeOnly("org.springframework.modulith:spring-modulith-runtime")

    // libraries
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    // dotenv
    implementation("io.github.cdimascio:java-dotenv:5.2.2")

    // db
    runtimeOnly("org.postgresql:postgresql")
    runtimeOnly("com.h2database:h2")

    // test
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
//    testImplementation("org.springframework.kafka:spring-kafka-test")
//    testImplementation("org.springframework.modulith:spring-modulith-starter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    // api docs
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:${property("swaggerVersion")}")
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.modulith:spring-modulith-bom:${property("springModulithVersion")}")
    }
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

// scripts 경로의 pre-commit hook 등록
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
        // chmod +x .git/hooks/pre-commit
    }
}

// compileKotlin가 addGitPreCommitHook에 의존하도록 설정
tasks.named("compileKotlin") {
    dependsOn("addLintPreCommitHook")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
