package com.mosby.library.utility;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.mosby.library.exception.LibraryServiceException;

@Component
@Aspect
public class LoggingAspect {
	private static final Log LOGGER = LogFactory.getLog(LoggingAspect.class);
	
	@AfterThrowing(pointcut="execution(* com.mosby.library.service.*Impl.*(..))",
			throwing="exception")
	public void logServiceException(LibraryServiceException exception) {
		LOGGER.error(exception.getMessage(), exception);
	}
}
