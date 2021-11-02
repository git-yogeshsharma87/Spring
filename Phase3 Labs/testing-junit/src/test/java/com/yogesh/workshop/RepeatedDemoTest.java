package com.yogesh.workshop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

public class RepeatedDemoTest {
	
	@RepeatedTest(5)
	void addNumber(RepetitionInfo repetitionInfo) {
		System.out.println("Runnin addNumber test ----->" + repetitionInfo.getCurrentRepetition());
		Assertions.assertEquals(2,Math.addExact(1, 1), "1 + 1 should be equal to 2");	
	}
	
	
}
