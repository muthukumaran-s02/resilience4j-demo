package io.github.robwin.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import io.github.resilience4j.retry.annotation.Retry;

@Service
public class MyService {

	@Retry(name="default", fallbackMethod = "defaultMethod")
	public String doProcess(String request) {
		long time = System.currentTimeMillis();
		if(((time % 1000)/60) % 2 == 1) {
			throw new NullPointerException();
		}
		if(StringUtils.hasLength(request)) {
			return "TRUE";
		} else {
			return "FALSE";
		}
	}
	
	public String defaultMethod(String request, Throwable error) {
		return "DEFAULT";
	}
}
