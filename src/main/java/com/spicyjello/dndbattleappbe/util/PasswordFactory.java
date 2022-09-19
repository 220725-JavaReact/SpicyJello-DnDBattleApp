package com.spicyjello.dndbattleappbe.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordFactory {
	private static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	public String encodePassword(String rawPassword) {
		return encoder.encode(rawPassword);
	}
	public Boolean matchPassword(String rawPassword, String encodedPassword) {
		return encoder.matches(rawPassword, encodedPassword);
	}
}
