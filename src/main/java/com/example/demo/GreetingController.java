package com.example.demo;

import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {

	@Value("${app_env:default_value}")
	String app_env;

	@RequestMapping("/greeting")
	public String greeting(@RequestHeader HttpHeaders headers) {
		JSONObject returnObj = new JSONObject();
		for (String key : headers.keySet()) {
			returnObj.put(key, headers.get(key).toString());
		}
		return returnObj.toString();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/appenv")
	public String readEnv(){
		return app_env;
	}

}
