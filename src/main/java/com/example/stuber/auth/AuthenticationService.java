package com.example.stuber.auth;

import com.example.stuber.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

	private final UserRepository userRepository;


	public AuthenticationResponse register(RegisterRequest registerRequest) {
		return null;
	}

	public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
		return null;
	}
}
