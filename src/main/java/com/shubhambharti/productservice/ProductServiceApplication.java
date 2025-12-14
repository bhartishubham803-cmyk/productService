package com.shubhambharti.productservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing
public class ProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

}

//*
//@EnableJpaAuditing is a Spring Boot annotation used in configuration classes to activate automatic auditing features in Spring Data JPA,
// enabling entities to track creation/modification dates and users via annotations like @CreatedBy, @CreatedDate, etc., by requiring an
//AuditorAware bean for current user info and marking entities with @EntityListeners(AuditingEntityListener.class)
//
//@EntityListeners(AuditingEntityListener.class):-Automatically manage auditing fields like creation/modification
// dates and users, by hooking into JPA lifecycle events (@PrePersist, @PreUpdate) and populating
// fields annotated with @CreatedBy, @CreatedDate, etc., in your entity.

// */