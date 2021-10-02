package hu.elosztott.iit.me.demo.github;


import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class RepoSearchDTO {
	@NotNull
	@Length(min=3)
	private String queryString;
}
