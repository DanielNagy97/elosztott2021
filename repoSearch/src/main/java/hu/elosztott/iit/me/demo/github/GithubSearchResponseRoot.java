package hu.elosztott.iit.me.demo.github;

import java.util.List;

import lombok.Data;

@Data
public class GithubSearchResponseRoot {
	private int total_count;
	private boolean incomplete_result;
	private List<GithubItemDTO> items;
}
