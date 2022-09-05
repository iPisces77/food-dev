
apply(plugin = "io.spring.dependency-management")
apply(plugin="java-library")
group = "com.ipisces42"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    api(project(":food-dev-service"))

}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}