
apply(plugin = "io.spring.dependency-management")

group = "com.ipisces42"
version = "0.0.1-SNAPSHOT"
apply(plugin="java-library")

repositories {
    mavenCentral()
}

dependencies {
    api(project(":food-dev-pojo"))
    implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:2.2.2")
    implementation("org.springframework.boot:spring-boot-starter-web")

}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}