package com.lemon1234.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
public class PimApplicationTest {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Test
	public void getPassword() {
		String password = bCryptPasswordEncoder.encode("admin");
		System.out.println(password);
	}
}
