package me.stamwoo.springbootrabbitmqdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringbootRabbitmqDemoApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(SpringbootRabbitmqDemoApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);
    }

    @Profile("usage_message")
    @Bean
    public CommandLineRunner usage() {
        return arg0 -> {
            System.out.println("This app uses Spring Profiles to control its behavior.\n");
            System.out.println("Sample usage: java -jar target/rabbitmq-tutorial-0.0.1-SNAPSHOT.jar --spring.profiles.active=hello-world,sender");
        };
    }

    @Profile("!usage_message")
    @Bean
    public CommandLineRunner tutorial() {
        return new RabbitTutorialRunner();
    }

}

