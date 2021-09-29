package hu.elosztott.iit.me.demo.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import hu.elosztott.iit.me.demo.Repo;
import hu.elosztott.iit.me.demo.RestCommunicationException;
import hu.elosztott.iit.me.demo.github.GithubSearchResponseRoot;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class GithubRepo implements Repo {

	private final String githubSearchRepositoryURL = "https://api.github.com/search/repositories";
	
	private final RestTemplate restTemplate;
	
	@Override
	public List<String> searchByText(String queryString) {
		String url = githubSearchRepositoryURL + "?q=" + queryString;
		ResponseEntity<GithubSearchResponseRoot> response = restTemplate.getForEntity(url, GithubSearchResponseRoot.class);
		
		if(response.getStatusCode() == HttpStatus.OK) {
			return response.getBody().getItems().stream().map(item -> item.getName()).collect(Collectors.toList());
		}
		else {
			throw new RestCommunicationException();
		}
					
	}

}
