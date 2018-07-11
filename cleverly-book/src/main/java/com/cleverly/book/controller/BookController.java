package com.cleverly.book.controller;

import com.cleverly.book.client.ApprovalClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableDiscoveryClient
@EnableFeignClients
public class BookController {

	@Autowired
	private ApprovalClient approvalClient;

	@GetMapping("/")
	public String fingBook() {
		return "Sucsess";
	}

	@GetMapping("/approval/{id}")
	public Long fingApproval(@PathVariable("id") Long id) {
		return approvalClient.findApproval(id);
	}
}
