package io.github.robwin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.github.robwin.service.MyService;

@RestController
@RequestMapping("/request")
public class MyController {

	@Autowired
	MyService myService;
	
	public MyService getMyService() {
		return myService;
	}

	public void setMyService(MyService myService) {
		this.myService = myService;
	}

	@GetMapping
	public String process(@RequestParam(name="name") String name) {
		return myService.doProcess(name);
	}
}
