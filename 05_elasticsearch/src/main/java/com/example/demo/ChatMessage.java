package com.example.demo;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.Builder;
import lombok.Data;

@Document(indexName = "chats")
@Data
@Builder
public class ChatMessage {
	@Id
	private String id;
	@Field(type = FieldType.Text)
	private String message;
	@Field(type = FieldType.Text)
	private String sender;
	@Field(type = FieldType.Text)
	private String roomId;
	@Field(type = FieldType.Text)
	private String roomName;
}
