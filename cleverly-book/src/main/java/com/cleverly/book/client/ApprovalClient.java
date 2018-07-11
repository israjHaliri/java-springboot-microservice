package com.cleverly.book.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cleverly-approval")
public interface ApprovalClient {

	@GetMapping("/{id}")
	Long findApproval(@PathVariable("id") Long id);
}
