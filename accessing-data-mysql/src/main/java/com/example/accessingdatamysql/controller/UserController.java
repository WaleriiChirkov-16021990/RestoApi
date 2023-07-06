package com.example.accessingdatamysql.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@GetMapping("/")
	public ResponseEntity getUsers() {
		try {
			return ResponseEntity.ok("сервер работает");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Ошибка запроса");
		}
		
	}
	@GetMapping("page")
	public ResponseEntity<String> getMyPage() {
		String html = "<html><body><h1>Привет, мир</h1></body></html>";
		return new ResponseEntity<>(html,HttpStatus.OK);
	}
	
	@GetMapping("first")
	public ResponseEntity<Resource> getMyFirstFilePage() {
		Resource html = new ClassPathResource("src/main/java/com/example/accessingdatamysql/html/pages/index.html");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.ALL);
		return new ResponseEntity<>(html,headers,HttpStatus.OK);
	}
}
