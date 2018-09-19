package com.haliri.israj.apporder.controller;

import com.haliri.israj.appcommon.dto.Item;
import com.haliri.israj.appcommon.dto.Request;
import com.haliri.israj.apporder.client.ItemClient;
import com.haliri.israj.apporder.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RequestController {

	@Autowired
	private RequestService requestService;

	@GetMapping("/")
	public List<Request> find() {
		return requestService.find();
	}

	@PostMapping("/save")
	public void save(@RequestBody Request request) {
		requestService.save(request);
	}
}
