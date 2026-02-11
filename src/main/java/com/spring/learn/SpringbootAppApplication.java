package com.spring.learn;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@SpringBootApplication(
        scanBasePackages = {
                "com.spring.learn.*",
                "com.self.learn.*"
        }
)
@EntityScan(basePackages="com.spring.learn.*")
@EnableJpaRepositories(basePackages = "com.spring.learn.*")
public class SpringbootAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringbootAppApplication.class, args);
	}

}
