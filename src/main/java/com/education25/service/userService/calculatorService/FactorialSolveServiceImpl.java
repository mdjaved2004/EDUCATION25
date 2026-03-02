package com.education25.service.userService.calculatorService;

public class FactorialSolveServiceImpl implements FactorialSolveService {

	@Override
	public String factorialResult(int inputValue) {
		//method call for solve factorial
		
		long calculateFactorial = calculateFactorial(inputValue);
		
		return calculateFactorial+"";
	}

	@Override
	public long calculateFactorial(int inputValue) {
		long factorial_result_value=0;
		// Number 1 and 0 is factorial always 1.
		if (inputValue == 0 || inputValue == 1) {
			factorial_result_value=1;
		} else {
			factorial_result_value=factorial_result_value+( inputValue * calculateFactorial(inputValue - 1));
		}
		return factorial_result_value;
	}
}