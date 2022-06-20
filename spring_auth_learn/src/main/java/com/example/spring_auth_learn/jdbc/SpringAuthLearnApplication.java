package com.example.spring_auth_learn.jdbc;

import com.example.spring_auth_learn.jdbc.entities.Authority;
import com.example.spring_auth_learn.jdbc.entities.User;
import com.example.spring_auth_learn.jdbc.repositories.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringAuthLearnApplication {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDetailsRepository userDetailsRepository;


    public static void main(String[] args) {
        SpringApplication.run(SpringAuthLearnApplication.class, args);
    }


    @PostConstruct
    protected void init() {
        List<Authority> authorityList = new ArrayList<>();
        authorityList.add(createAuthority("USER", "User role"));
        authorityList.add(createAuthority("ADMIN", "Admin role"));

        User user = new User();
        user.setUserName("artem");
        user.setFirstName("Artem");
        user.setLastName("Gavshin");
        user.setPassword(passwordEncoder.encode("test"));
        user.setEnabled(true);
        user.setAuthorities(authorityList);
        userDetailsRepository.save(user);

    }

    private Authority createAuthority(String roleCode, String roleDescription) {
        Authority authority = new Authority();
        authority.setRoleCode(roleCode);
        authority.setRoleDescription(roleDescription);
        return authority;
    }
}
