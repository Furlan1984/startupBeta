package br.com.check.market.controller;

import java.util.concurrent.atomic.AtomicLong;
import br.com.check.market.model.User;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {
	
	
	private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/user")
    public User getUser(@RequestParam(value="name", defaultValue="World") String name) {
        return new User(name);
    }

}
