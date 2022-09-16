package com.spicyjello.dndbattleappbe.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggerAspect {
	private Logger logger = LogManager.getLogger(this.getClass());
	@Before("execution (* com.spicyjello.dndbattleappbe.*.*.*(..)) && !execution (* com.spicyjello.dndbattleappbe.model.*.*(..)) && !execution (* com.spicyjello.dndbattleappbe.util.*.*(..))")
	public void beforeControllerMethods(JoinPoint point) {
		logger.info(point.getSignature().getDeclaringTypeName() + " received request to " + point.getSignature().getName() + "...");
	}
	@AfterThrowing(value="execution (* com.spicyjello.dndbattleappbe.*.*.*(..))", throwing="exception")
	public void afterThrowingException(JoinPoint point, Object exception) {
		logger.warn(point.getSignature().getDeclaringTypeName() + " encountered an exception...", (Exception) exception);
	}
}
