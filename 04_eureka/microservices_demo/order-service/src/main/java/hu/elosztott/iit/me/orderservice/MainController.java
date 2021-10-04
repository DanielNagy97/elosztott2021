package hu.elosztott.iit.me.orderservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MainController {
	
	private final StorageClient storageClient;
	
	@GetMapping("/order")
	public String Order() {
		int remainingProducts = storageClient.deliver();
		return "Order confirmed! Remaining products: " + remainingProducts;
	}
}
