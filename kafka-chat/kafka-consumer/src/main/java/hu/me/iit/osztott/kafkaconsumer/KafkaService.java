package hu.me.iit.osztott.kafkaconsumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

	@KafkaListener(topics="chat-rooms")
	void listen(ConsumerRecord<Long, String> message) {
		System.out.println(message.value());
	}
}
