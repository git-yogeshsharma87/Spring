package com.yogesh.workshop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

@DisplayName("conditional test")
public class ConditionalTest {
	
	@Test
	@EnabledOnOs({OS.WINDOWS})
	public void executeOnWindows() { 
		System.out.println("this method will be executed in Windows OS");
	}
	
	@Test
	@EnabledOnOs(OS.LINUX)
	public void executeOnLinux() { 
		System.out.println("this method will be executed in Linux OS");
	}

}
