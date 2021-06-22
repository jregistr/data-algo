import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.10"
//    scala
}

group = "me.jregistr"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
//    implementation("org.scala-lang:scala3-library_3:3.0.0")
//    testImplementation("org.scalatest:scalatest_3:3.2.9")
    testImplementation(kotlin("test"))
    testImplementation(platform("org.junit:junit-bom:5.7.2"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}