package hu.elosztott.iit.me.demo.impl;

import org.springframework.stereotype.Service;

@Service
public class Calculator2 implements hu.elosztott.iit.me.demo.Calculator {

	@Override
	public Double add(Double operandus1, Double operandus2) {
		// TODO Auto-generated method stub
		return operandus1 + operandus2;
	}

}
