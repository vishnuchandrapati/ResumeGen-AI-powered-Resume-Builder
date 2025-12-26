package com.vishnu.resumeGen;

import jakarta.annotation.PostConstruct;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ResumeGenApplicationTests {
	@Test
	void context(){

	}
	@PostConstruct
	public void checkEnv() {
		System.out.println(System.getenv("DB_URL"));
	}
}
