package com.example.springsection28.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Pointcut;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {
	
	// Setup logger
	private Logger logger = Logger.getLogger(getClass().getName());
	
	// Setup pointcut declarations
	@Pointcut("execution(* com.example.springsection28.controller.*.*(..))")
	private void forControllerPackage() {
		
	}
	
	@Pointcut("execution(* com.example.springsection28.service.*.*(..))")
	private void forServicePackage() {
		
	}
	
	@Pointcut("execution(* com.example.springsection28.dao.*.*(..))")
	private void forDAOPackage() {
		
	}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
	private void forAppFlow() {
		
	}
	
	// Add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		
		// Display the method called
		String method = theJoinPoint.getSignature().toShortString();
		logger.info("=====>> Inside @Before advice: Calling method: " + method);
		
		// Display the arguments of the method called
		Object[] args = theJoinPoint.getArgs();
		for (Object tempArg : args)
			logger.info("=====>> Argument: " + tempArg);
		
	}
	
	// Add @AfterReturning Advice
	@AfterReturning(
			pointcut = "forAppFlow()", 
			returning = "theResult"
		)
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
		
		// Display method we are returning from
		String method = theJoinPoint.getSignature().toShortString();
		logger.info("=====>> Inside @AfterReturning advice: From method: " + method);
		
		// Display data returned
		logger.info("=====>> Data returned: " + theResult);
		
	}

}
