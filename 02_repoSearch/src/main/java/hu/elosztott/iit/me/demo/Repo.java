package hu.elosztott.iit.me.demo;

import java.util.List;

public interface Repo {
	List<String> searchByText(String queryString);
}
