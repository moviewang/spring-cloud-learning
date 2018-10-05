package com.zipkin.server;

import com.zipkin.server.service.SleuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import zipkin.storage.mysql.MySQLStorage;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@RestController
public class ZipkinServerApplication {
	@Resource
	private SleuthService sleuthService;
	@Resource
	private Executor executor;
	@Resource
	private RestTemplate restTemplate;


	private static final Logger log = LoggerFactory.getLogger(ZipkinServerApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(ZipkinServerApplication.class, args);
	}

	@RequestMapping("/home")
	public String home() {
		log.info("Handling home");
		return "Hello World";
	}

	@RequestMapping("/same-span")
	public String sameSpan() throws InterruptedException {
		log.info("same span");
		sleuthService.doSomeWorkSpan();
		return "Hello World";
	}

	@RequestMapping("/new-span")
	public String newSpan() throws InterruptedException {
		log.info("new span");
		sleuthService.newSpan();
		return "success";
	}

	@RequestMapping("/new-thread")
	public String newThread() throws InterruptedException {
		log.info("new thread");
		executor.execute(() -> {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			log.info("I'm inside the new thread - with a new span");
		});
		log.info("I'm done in the original span");
		return "success";
	}

	@RequestMapping("/async")
	public String async() throws InterruptedException {
		log.info("before async method call");
		sleuthService.async();
		log.info("after async call");
		return "success";
	}

	@GetMapping("/zipkin1")
	public String zipkin() {
		log.info("zipkin 2");
		restTemplate.exchange("http://localhost:8083/zipkin2",
				HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
				}).getBody();
		return "hi";
	}

	@Bean
	public MySQLStorage mySQLStorage(DataSource dataSource) {
		return MySQLStorage.builder().datasource(dataSource).executor(Runnable::run).build();
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
