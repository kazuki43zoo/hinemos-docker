package com.example.demo;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    @GetMapping("/file")
    public ResponseEntity<String> viewFile(@RequestParam(name = "path", defaultValue = "/var/log/demo-console.log") String path) throws IOException {
      Resource logFile = new FileSystemResource(path);
      return logFile.exists() ? ResponseEntity.ok(StreamUtils.copyToString(logFile.getInputStream(), StandardCharsets.UTF_8)) : ResponseEntity.notFound().build();
    }
  }

}
