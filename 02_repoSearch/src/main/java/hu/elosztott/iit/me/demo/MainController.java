package hu.elosztott.iit.me.demo;


import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.elosztott.iit.me.demo.github.RepoSearchDTO;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MainController {

	private final Calculator calculator;
	private final Repo repo;

	@RequestMapping("/")
	String main() {
		return "Hello World!";
	}
	
	@RequestMapping(path = "/calculator", produces = MediaType.APPLICATION_JSON_VALUE)
	Double calculate(@Valid CalculatorRequestDTO calculatorRequestDTO) {
		return calculator.add(calculatorRequestDTO.getOperandus1(), calculatorRequestDTO.getOperandus2());
	}
	
	@RequestMapping(path = "/repoSearch", produces = MediaType.APPLICATION_JSON_VALUE)
	List<String> repoSearch(@Valid RepoSearchDTO repoSearchDTO) {
		return repo.searchByText(repoSearchDTO.getQueryString());
	}
}

/*
@Controller
public class MainController {

	@RequestMapping("/")
	@ResponseBody
	String main() {
		return "Hello World!";
	}
}
*/