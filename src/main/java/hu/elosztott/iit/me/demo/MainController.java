package hu.elosztott.iit.me.demo;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MainController {

	private final Calculator calculator;

	@RequestMapping("/")
	String main() {
		return "Hello World!";
	}
	
	@RequestMapping(path = "/calculator", produces = MediaType.APPLICATION_JSON_VALUE)
	Double calculate(@Valid CalculatorRequestDTO calculatorRequestDTO) {
		return calculator.add(calculatorRequestDTO.getOperandus1(), calculatorRequestDTO.getOperandus2());
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