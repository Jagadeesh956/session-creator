package com.spring.learn;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(
        scanBasePackages = {
                "com.spring.learn.*",
                "com.self.learn.*"
        }
)
@EntityScan(basePackages="com.self.learn.session.dao")
@EnableJpaRepositories(basePackages = "com.self.learn.session.dao")
public class SpringbootAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringbootAppApplication.class, args);
	}

}
