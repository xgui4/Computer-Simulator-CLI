plugins {
    id("java")
}

group = "net.xgui4"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

tasks.register<JavaExec>("run") {
    mainClass.set("net.xgui4.Simulator") // Replace with your main class
    classpath = sourceSets["main"].runtimeClasspath
}
