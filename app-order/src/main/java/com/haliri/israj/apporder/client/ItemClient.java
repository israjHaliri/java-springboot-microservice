package com.haliri.israj.apporder.client;

import com.haliri.israj.appcommon.dto.Item;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "product")// this eureka service name
@RibbonClient(name="product")
public interface ItemClient {

	@PutMapping("products/update-amount")
	void updateAmount(@RequestParam("id") Integer id);

	@GetMapping("products/find-by-id/{id}")
	Item findById(@PathVariable("id") Object id);
}
