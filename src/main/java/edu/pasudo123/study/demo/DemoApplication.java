package edu.pasudo123.study.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.ApplicationPidFileWriter;

import javax.annotation.PreDestroy;

@Slf4j
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		SpringApplication application =  new SpringApplicationBuilder(DemoApplication.class)
				.build();
		application.addListeners(new ApplicationPidFileWriter("./bin/appliation.pid"));
		application.run(args);
	}

	@PreDestroy
	public void onShutDown() {
		// https://youtrack.jetbrains.com/issue/GO-2899?_ga=2.260181194.672989913.1602658032-2067497902.1598770350&_gac=1.95148398.1602658033.Cj0KCQjwoJX8BRCZARIsAEWBFMJXKajj-3VGBfhZMuULjpFPVebmiyskf521AkSYTYp96tmJszO_HSkaAkRvEALw_wcB

		// https://dzone.com/articles/managing-spring-boot
		// graceful shutdown
		// spring boot 2.2.7 version
		log.warn("[pre-destroy] closing application context...");
	}
}
