package com.company.factorial;

import org.springframework.stereotype.Component;

@Component("forc")
public class ForCalculator implements Calculator {

	@Override
	public long factorial(long num) {//num 안에 calculator에 들어올 숫자가 들어옴

		long result = 1;
		for (int i=1;i<=num;i++) {
			result *= i;
			
		}
		
		return result;
	}

}
