plugins {
    kotlin("jvm") version "2.1.0"
    kotlin("plugin.serialization") version "2.1.20"
    id("com.gradleup.shadow") version "9.0.0-beta12"
}

group = "ge.nika"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json-jvm:1.8.1")
    implementation("com.charleskorn.kaml:kaml:0.77.0")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(11)
}

tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = "ge.nika.MainKt"
    }
}