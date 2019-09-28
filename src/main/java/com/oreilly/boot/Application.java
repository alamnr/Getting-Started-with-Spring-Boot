package com.oreilly.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/*@EnableAutoConfiguration
//@Import(MyConfiguration.class)
@ComponentScan()
*/
@SpringBootApplication
@RestController
public class Application {
	
	@Value("${name}")
	private String name;
	
	private String message;
	
	@Autowired
	public void setMessage(String message) {
		this.message = message;
	}

	@RequestMapping("/")
	public String home() {
		return "Hello World " +  name  +   message;
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

}
