package hu.elosztott.iit.me.demo.github;

import java.util.List;

import lombok.Data;

@Data
public class GithubItemDTO {
	private String name;
	private String path;
	private String url;

	private List<GithubRepoDTO> githubRepoDTO;
}
