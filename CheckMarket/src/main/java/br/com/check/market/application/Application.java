package br.com.check.market.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import br.com.check.market.controller.UserController;


@SpringBootApplication
@ComponentScan(basePackageClasses = UserController.class)
public class Application {

	  public static void main(String[] args) {
		  SpringApplication.run(Application.class, args);
	    }
}
