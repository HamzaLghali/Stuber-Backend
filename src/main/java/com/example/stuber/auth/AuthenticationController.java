package com.example.stuber.auth;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

	private final AuthenticationService authenticationService;

	@PostMapping("/Register")
	public ResponseEntity<AuthenticationResponse> register(
			@RequestBody RegisterRequest registerRequest)
	{
		return ResponseEntity.ok(authenticationService.register(registerRequest));
	}

	@PostMapping("/Authenticate")
	public ResponseEntity<AuthenticationResponse> register(
			@RequestBody AuthenticationRequest authenticationRequest)
	{
		return ResponseEntity.ok(authenticationService.authenticate(authenticationRequest));
	}

	@PostMapping("/refresh-token")
	public void refreshToken(
			HttpServletRequest request,
			HttpServletResponse response
	) throws IOException {
		authenticationService.refreshToken(request, response);
	}
}
