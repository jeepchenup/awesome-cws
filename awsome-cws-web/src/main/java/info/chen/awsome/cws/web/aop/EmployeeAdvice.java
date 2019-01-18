package info.chen.awsome.cws.web.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class EmployeeAdvice {

	@Before("info.chen.awsome.cws.web.aop.SystemArchitecture.inDataAccessLayer()")
	public void doAccessCheck() {
		System.out.println("start to access equipment data");
	}
}
