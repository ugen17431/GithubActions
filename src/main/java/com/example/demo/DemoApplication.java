package com.example.demo;

import com.example.demo.ServiceFolder.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootApplication
@RestController
public class DemoApplication {

	@Autowired
	public ServiceImpl serviceImpl;

	Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/status")
	public String status() {
		return "Running";

	}

	@GetMapping("/xl")
    public ResponseEntity<Resource> downloadExcel() throws IOException {

		logger.info("/xl api called.");

		InputStreamResource file = new InputStreamResource(serviceImpl.generateExcel());

		LocalDateTime dateTime = LocalDateTime.now();

		return  ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + dateTime.toString() +".xlsx")
				.contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
				.body(file);
	}

}
