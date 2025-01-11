tasks.getByName("bootJar") {
    enabled = true
}

tasks.getByName("jar") {
    enabled = false
}

dependencies {
    implementation(project(":wallet"))
    implementation(project(":payment"))
    implementation(project(":transfer"))
    implementation(project(":account"))
}
