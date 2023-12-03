package com.learn.preparation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class PreparationApplication {

	public static void main(String[] args) {
		SpringApplication.run(PreparationApplication.class, args);
		log.info("PreparationApplication Started .....");
	}

}
