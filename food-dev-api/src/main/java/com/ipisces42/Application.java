package com.ipisces42;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.support.DefaultSingletonBeanRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;

/**
 * 启动类
 */
@SpringBootApplication()
@MapperScan(basePackages = "com.ipisces42.mapper")
@ComponentScan(basePackages = {"com.ipisces42", "org.n3r.idworker"})
public class Application {

    /**
     * 主启动方法
     * @param args
     */
    public static void main(String[] args) {

        var context = SpringApplication.run(Application.class, args);
        Field singletonObjects = null;
        try {
            singletonObjects = DefaultSingletonBeanRegistry.class.getDeclaredField("singletonObjects");
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        singletonObjects.setAccessible(true);
        var beanFactory = context.getBeanFactory();
        try {
            // 返回指定对象该字段的值
            var o = (Map<String, Object>) singletonObjects.get(beanFactory);
            o.forEach((k, v) -> {
                System.out.println(k + ":" + v);
            });
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        context.getMessage("hello", null, Locale.CHINESE);
        context.getMessage("hello", null, Locale.TRADITIONAL_CHINESE);
        context.getMessage("hello", null, Locale.ENGLISH);

        Resource[] resources = new Resource[0];
        try {
            resources = context.getResources(
                    "classpath:META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Arrays.stream(resources).forEach(System.out::println);

        System.out.println(context.getEnvironment().getProperty("JAVA_HOME"));
        System.out.println(context.getEnvironment().getProperty("server.port"));

        //

    }
}