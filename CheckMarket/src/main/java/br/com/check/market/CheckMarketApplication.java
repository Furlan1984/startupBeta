package br.com.check.market;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
public class CheckMarketApplication {

	  public static void main(String[] args) {
		  //testando 
		  SpringApplication.run(CheckMarketApplication.class, args);
	    }
}
