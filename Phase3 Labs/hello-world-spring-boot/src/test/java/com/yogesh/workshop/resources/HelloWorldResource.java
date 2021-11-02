package com.yogesh.workshop.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*@Controller
public class HelloWorldResource {

@RequestMapping(path ="/hello", method = REQUEST.GET)
	public @ResponseBody String hello() {
		
		return "Hello World ! ";
	}
	*/
@RestController
public class HelloWorldResource {

	@GetMapping(path = "/hello")
	public String hello(@RequestParam(value ="name",defaultValue= "World") String name) {
		
		return String.format("Hello %s!" , name);
	}
	
	
}

