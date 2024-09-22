package com.example.demo;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

  @RestController
  public static class HelloController {
    private static Logger logger = LoggerFactory.getLogger(HelloController.class);
    @GetMapping("/")
    public String hello() throws UnknownHostException {
      String hostname = InetAddress.getLocalHost().getHostName();
      logger.info("hello on {}", hostname);
      return "hello on " + hostname;
    }
  }

}
