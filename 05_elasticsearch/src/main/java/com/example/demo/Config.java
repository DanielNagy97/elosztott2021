package com.example.demo;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(
		basePackages = "com.example.demo"
		)
public class Config extends AbstractElasticsearchConfiguration{

	@Override
	public RestHighLevelClient elasticsearchClient() {
		// TODO Auto-generated method stub
		return RestClients.create(ClientConfiguration.localhost()).rest();
	}
	
}
