plugins {
    id("java-library")
    id("io.spring.dependency-management") version "1.0.13.RELEASE"
    id("org.springframework.boot") version "2.7.3"
    id("io.freefair.lombok") version "6.5.0.3"
}


allprojects {
    group = "com.ipisces42"
    version = "0.0.1-SNAPSHOT"
    repositories {
        mavenCentral()
    }
}
repositories {
    mavenCentral()
}
subprojects {
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "java-library")
    apply(plugin = "io.freefair.lombok")
    java {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    tasks.withType<JavaCompile>() {
        options.encoding = "UTF-8"

    }



    configurations {
        compileOnly {
            extendsFrom(configurations.annotationProcessor.get())
        }
    }

    configurations.all {
        exclude("org.springframework.boot", "spring-boot-starter-tomcat")
        exclude("org.springframework.boot", "spring-boot-starter-logging")
    }
    configurations.all() {

    }
    dependencies {
        implementation(platform("org.springframework.boot:spring-boot-dependencies:2.7.2"))
        implementation("org.springframework.boot:spring-boot-configuration-processor")
       implementation("org.springdoc:springdoc-openapi-ui:1.6.10")
        annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
        implementation("org.springframework.boot:spring-boot-starter-web")
        implementation("org.springframework.boot:spring-boot-starter-jetty")
        implementation("org.springframework.boot:spring-boot-starter-log4j2")
        implementation("org.springframework.boot:spring-boot-starter-aop")
        implementation("org.apache.commons:commons-lang3:3.12.0")
        implementation("org.springframework.boot:spring-boot-starter-validation")
        implementation("commons-codec:commons-codec:1.15")
        implementation("com.github.xiaoymin:knife4j-springdoc-ui:3.0.3")
        implementation ("org.mapstruct:mapstruct:1.5.2.Final")
        implementation("org.projectlombok:lombok-mapstruct-binding:0.2.0")

        annotationProcessor ("org.mapstruct:mapstruct-processor:1.5.2.Final")
        testImplementation("org.springframework.boot:spring-boot-starter-test")
        implementation("com.baomidou:mybatis-plus-boot-starter:3.5.2")
        implementation("mysql:mysql-connector-java")
    }

    tasks.getByName<Test>("test") {
        useJUnitPlatform()
    }
}
