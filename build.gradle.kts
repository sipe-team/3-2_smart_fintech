import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.9.25"
    kotlin("plugin.spring") version "1.9.25" apply false
    id("org.springframework.boot") version "3.4.1" apply false
    id("io.spring.dependency-management") version "1.1.7" apply false
    id("org.jlleitschuh.gradle.ktlint") version "12.1.1" apply false
}

allprojects {
    group = property("projectGroup").toString()
    version = property("applicationVersion").toString()
}

subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "org.jetbrains.kotlin.plugin.spring")
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "org.springframework.boot")

    java {
        sourceCompatibility = JavaVersion.VERSION_21
    }

    dependencies {
        implementation("org.springframework.boot:spring-boot-starter")
        testImplementation("org.springframework.boot:spring-boot-starter-test")
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
        testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs += "-Xjsr305=strict"
            jvmTarget = JavaVersion.VERSION_21.toString()
        }
    }

    tasks.getByName("bootJar") {
        enabled = false
    }

    tasks.getByName("jar") {
        enabled = true
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }

//    // scripts 경로의 pre-commit hook 등록
//    tasks.register("addLintPreCommitHook", DefaultTask::class) {
//        group = "setup"
//        description = "Install git hooks"
//        doLast {
//            val hooksDir = project.file(".git/hooks")
//            val scriptDir = project.file("scripts")
//            val preCommit = scriptDir.resolve("pre-commit")
//            preCommit.copyTo(hooksDir.resolve("pre-commit"), overwrite = true)
//            hooksDir.resolve("pre-commit").setExecutable(true)
//        }
//    }

//    // compileKotlin가 addGitPreCommitHook에 의존하도록 설정
//    tasks.named("compileKotlin") {
//        dependsOn("addLintPreCommitHook")
//    }
}
