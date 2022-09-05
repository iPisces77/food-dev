
group = "com.ipisces42"
version = "0.0.1-SNAPSHOT"
apply(plugin = "io.spring.dependency-management")
apply(plugin="java-library")

repositories {
    mavenCentral()
}

dependencies {

}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}