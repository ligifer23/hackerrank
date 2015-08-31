package com.wmoreira.javadevn1.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by welingtonmoreira on 31/08/15.
 */
@SpringBootApplication
public class App {

    public static void main(String[] args) {
	SpringApplication.run(new Class[] {AppConfig.class, WebInitializer.class}, args);
    }

}
