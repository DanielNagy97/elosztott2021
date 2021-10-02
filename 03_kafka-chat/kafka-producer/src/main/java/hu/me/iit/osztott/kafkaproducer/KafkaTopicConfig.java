package hu.me.iit.osztott.kafkaproducer;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfig {
	@Bean
	public NewTopic createTopic() {
		return TopicBuilder.name("chat-rooms")
				.partitions(1)
				.replicas(1)
				.build();
	}
}
