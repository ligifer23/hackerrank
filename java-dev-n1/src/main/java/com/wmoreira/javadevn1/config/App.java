package com.wmoreira.javadevn1.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wellington.362@gmail.com
 */
@SpringBootApplication
public class App {

    public static void main(String[] args) {
	    SpringApplication.run(new Class[] {AppConfig.class, WebInitializer.class}, args);
    }

}
