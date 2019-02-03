package me.stamwoo.configservergit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableConfigServer
@SpringBootApplication
public class ConfigServerGitApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerGitApplication.class, args);
	}

}

