
val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project

val exposed_version: String by project
val h2_version: String by project
plugins {
    kotlin("jvm") version "1.9.10"
    id("io.ktor.plugin") version "2.3.4"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.9.10"
}

group = "com.fiap"
version = "0.0.1"

application {
    mainClass.set("com.fiap.ApplicationKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core-jvm")
    implementation("io.ktor:ktor-serialization-kotlinx-json-jvm")
    implementation("io.ktor:ktor-server-content-negotiation-jvm")
    implementation("org.jetbrains.exposed:exposed-core:$exposed_version")
    implementation("org.jetbrains.exposed:exposed-jdbc:$exposed_version")
    implementation("com.h2database:h2:$h2_version")
    implementation("io.ktor:ktor-server-netty-jvm")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    testImplementation("io.ktor:ktor-server-tests-jvm")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
    //oracle
    implementation("com.oracle.database.jdbc:ojdbc8:23.2.0.0")
    //mongo db
    implementation("org.litote.kmongo:kmongo:4.9.0")
    implementation("org.litote.kmongo:kmongo-coroutine:4.9.0")
    implementation("org.litote.kmongo:kmongo-coroutine-core:4.9.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")
    //koin
    implementation("io.insert-koin:koin-core:3.2.0")
    implementation("io.insert-koin:koin-core-jvm:3.2.0")
    implementation("io.insert-koin:koin-ktor:3.2.0")

    //http ktor
    implementation("io.ktor:ktor-client-core-jvm:1.6.3")
    implementation("io.ktor:ktor-client-cio-jvm:1.6.3")
    implementation("io.ktor:ktor-client-serialization-jvm:1.6.3")
    implementation("io.ktor:ktor-client-logging-jvm:1.6.3")
    implementation("io.ktor:ktor-client-json-jvm:1.6.3")
    //ktor apache jvm
    implementation("io.ktor:ktor-client-apache-jvm:1.6.3")
    implementation("io.ktor:ktor-server-cio-jvm:$ktor_version")
    implementation("io.ktor:ktor-client-cio:$ktor_version")
    //content negotiation jvm
    implementation("io.ktor:ktor-serialization:$ktor_version")
    implementation("io.ktor:ktor-serialization-gson:$ktor_version")
    implementation("io.ktor:ktor-server-content-negotiation-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-core-jvm:$ktor_version")
    implementation("io.ktor:ktor-serialization-gson-jvm:$ktor_version")
    implementation("io.ktor:ktor-client-content-negotiation-jvm:$ktor_version")


    //gson google
    implementation("com.google.code.gson:gson:2.8.8")

}
