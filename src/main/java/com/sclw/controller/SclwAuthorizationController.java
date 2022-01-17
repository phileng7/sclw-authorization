package com.sclw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sclw.dto.LoginDTO;
import com.sclw.dto.TokenDTO;
import com.sclw.service.LoginService;

@RestController
public class SclwAuthorizationController {
	
	@Autowired
	private LoginService loginService;
	
	@GetMapping("/")
	public ResponseEntity<String> home() {
		return new ResponseEntity<String>("Greetings from SCL Web Cloud!", HttpStatus.OK);
	}

	@PostMapping("/login")
	public ResponseEntity<TokenDTO> purelogin(@RequestBody LoginDTO userLogin) {		
		TokenDTO retToken = loginService.validateLogin(userLogin);
		HttpHeaders responseHeaders = new HttpHeaders();
		//responseHeaders.set("Access-Control-Allow-Origin", "*");
		//responseHeaders.set("Access-Control-Allow-Credentials", "true");
		responseHeaders.set("access-control-expose-headers", "Authorization");
		responseHeaders.set("Authorization", "Bearer " + retToken.getAuthorization());		

		return new ResponseEntity<TokenDTO>(retToken, responseHeaders, HttpStatus.OK);
	}

	@PostMapping("/auth/register")
	public ResponseEntity<String> register(@RequestBody String userName) {
		// Persist user to some persistent storage
		System.out.println("Info saved...");

		return new ResponseEntity<String>("Registered", HttpStatus.OK);
	}

}
