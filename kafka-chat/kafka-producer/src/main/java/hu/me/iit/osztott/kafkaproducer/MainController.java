package hu.me.iit.osztott.kafkaproducer;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class MainController {
	
	private final KafkaService kafkaService;
	
	public MainController(KafkaService kafkaService) {
		super();
		this.kafkaService = kafkaService;
	}

	@PostMapping("/send-message")
	void main(@RequestBody MessageDTO message) throws JsonProcessingException {
		kafkaService.sendMessage(message);
	}

}
