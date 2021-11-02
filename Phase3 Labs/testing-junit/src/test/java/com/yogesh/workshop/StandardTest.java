package com.yogesh.workshop;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class StandardTest {
	
	@BeforeAll
	void initAll() {
		System.out.println("executed before  all the test methods");
	}
	
	@BeforeEach
	void init() {
		System.out.println("before each test method");
	}
	
		@Test
		@Disabled
		void failingTest() { 
			fail("this method always fails");
		}
		
		@Test
		void succedingTest() {
			System.out.println("always pass");
		}
		
		@Test
		void succedingTest2() {
			System.out.println("always pass 2");
		}
		
		@AfterEach
		void tearDown() {
			System.out.println("after each method is invoked");
		}
		
		@AfterAll
		void tearDownAll() {
			System.out.println("after all method is invoked");
		}
}
