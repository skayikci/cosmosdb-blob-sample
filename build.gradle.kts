plugins {
    java
    `maven-publish`
    id("org.springframework.boot") version "3.3.0"
    id("io.spring.dependency-management") version "1.1.5"
}

group = "com.cosmos"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "com.cosmos"
            from(components["java"])

        }
    }
}

repositories {
    mavenCentral()
}

extra["springCloudAzureVersion"] = "5.13.0"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.azure:azure-storage-blob")
    implementation("com.azure:azure-identity")
    implementation("com.azure.spring:spring-cloud-azure-starter-data-cosmos")
    implementation("com.azure.spring:spring-cloud-azure-starter-appconfiguration-config")
    implementation("org.mapstruct:mapstruct:1.5.5.Final")
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    annotationProcessor("org.mapstruct:mapstruct-processor:1.5.5.Final")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

dependencyManagement {
    imports {
        mavenBom("com.azure.spring:spring-cloud-azure-dependencies:${property("springCloudAzureVersion")}")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
