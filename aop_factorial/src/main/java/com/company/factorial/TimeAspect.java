package com.company.factorial;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TimeAspect {
	
	@Around(value="execution(* com.company.factorial..*(..))") //들어갈 시점을 제시
	public Object measure(ProceedingJoinPoint pjp) throws Throwable { // around 사용시 ProceedingJoinPoint pjp를 적어야 한다.(실제로 호출하는 메소드)
		
		//시작 시간
		long start = System.nanoTime();
		
		//실제 수행 메소드 호출
		try {
			Object obj= pjp.proceed();
			return obj;
		} finally {
			//종료 시간
			long end = System.nanoTime();
			System.out.println("걸린 시간 : "+(end+start));
		}
	}
}
