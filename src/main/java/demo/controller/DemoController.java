package demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	
	@GetMapping("/")
	public String showHome() {
		return "Home";
	}

	@GetMapping("/leaders")
	public String showLeaders() {
		return "Leaders";
	}
	
	@GetMapping("/system")
	public String showSystem() {
		return "System";
	}
}
