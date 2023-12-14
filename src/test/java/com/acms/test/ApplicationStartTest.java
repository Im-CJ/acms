package com.acms.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.acms.SpringBootJaxrsApplication;

@RunWith(SpringRunner.class)
public class ApplicationStartTest {
	@Test
	public void applicationStarts() {
		SpringBootJaxrsApplication.main(new String[] {});
	}
}