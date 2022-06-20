package com.example.spring_auth_learn.clean;


import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;


import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringAuthLearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAuthLearnApplication.class, args);
    }


    // *** Clean architecture ****
    @Bean
    BeanFactoryPostProcessor beanFactoryPostProcessor(ApplicationContext beanRegistry) {
        final var factory = ((AnnotationConfigServletWebServerApplicationContext) beanRegistry).getBeanFactory();
        return beanFactory -> {
            genericApplicationContext((BeanDefinitionRegistry) factory);
        };
    }

    void genericApplicationContext(BeanDefinitionRegistry beanRegistry) {
        var beanDefinitionScanner = new ClassPathBeanDefinitionScanner(beanRegistry);
        beanDefinitionScanner.addIncludeFilter(removeModelAndEntitiesFilter());
        beanDefinitionScanner.scan("com.example.spring_auth_learn");
    }

    static TypeFilter removeModelAndEntitiesFilter() {
        return (MetadataReader mr, MetadataReaderFactory mrf) -> !mr.getClassMetadata()
                .getClassName()
                .endsWith("Model");
    }
}
