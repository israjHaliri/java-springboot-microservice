package com.haliri.israj.appproduct.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApprovalController {
	
	@GetMapping("/{id}")
	public Long add(@PathVariable("id") Long id) {
		return id;
	}
}
