package org.monkey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by monkey on 2017/1/5.
 */

@SpringBootApplication
@EnableScheduling
@EnableAutoConfiguration
public class Application extends SpringBootServletInitializer{


    public static void main(String[] args) {
        System.out.println("Starting.........");
        SpringApplication.run(Application.class ,args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

}
