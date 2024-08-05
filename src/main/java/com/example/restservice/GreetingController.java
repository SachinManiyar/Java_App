package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@GetMapping("/greeting2")
	public Greeting greeting2(@RequestParam(value = "name", defaultValue = "World2") String name) {
		// Unused variable
		int unusedVariable = 42;

		// Potential null pointer exception
		String nullString = null;
		if (nullString.equals("test")) {
			System.out.println("This will throw a NullPointerException");
		}

		// Duplicated string literal
		String duplicateString = "duplicate";
		if ("duplicate".equals(duplicateString)) {
			System.out.println("This is a duplicated string literal");
		}

		// Dead code
		unusedMethod();

		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	private void unusedMethod() {
		System.out.println("This method is never used");
	}

}
