package com.example.demo;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("chat")
public class ChatController {
	private final ChatMessageRepository chatMessageRepository;
	
	@PostMapping()
	public void newData(@RequestBody @Valid ChatMessageDto chatMessageDto) {
		chatMessageRepository.save(chatMessageDto.toDocument());
		
	}

	@GetMapping(consumes = "application/json")
	public Page<ChatMessage> findMessage(@RequestBody @Valid FindByDto senderDto) {
		return chatMessageRepository.findBySender(
				senderDto.getQuery(),
				PageRequest.of(0, 10)
				);
	}
	
	@RequestMapping("bymessage")
	@GetMapping(consumes = "application/json")
	public Page<ChatMessage> findMessageByMessage(@RequestBody @Valid FindByDto senderDto) {
		return chatMessageRepository.findByMessage(
				senderDto.getQuery(),
				PageRequest.of(0, 10)
				);
	}

}
