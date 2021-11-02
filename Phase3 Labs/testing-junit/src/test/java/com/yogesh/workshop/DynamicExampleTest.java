package com.yogesh.workshop;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

public class DynamicExampleTest {
	
	// static test 
	@Test
	void test() {
		Assertions.assertEquals(5, Math.addExact(3, 2));
	}
	
	@TestFactory
	Collection<DynamicTest> test_from_collection() {
		return Arrays.asList(
				dynamicTest("simple dynamic test", () -> assertTrue(true)),
				dynamicTest("Executable test", new MyExecutable())
				);
	}
}

class MyExecutable implements Executable {
	
	public void execute() throws Throwable {
		System.out.println("Hello World");
	}
}