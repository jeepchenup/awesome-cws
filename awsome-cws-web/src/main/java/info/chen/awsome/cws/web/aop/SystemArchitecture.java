package info.chen.awsome.cws.web.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SystemArchitecture {

	@Pointcut("execution(* info.chen.awsome.cws.persist.dao..*)")
	public void inDataAccessLayer() {}
	
	@Pointcut("execution(* info.chen.awsome.cws.service..*)")
	public void inServiceAccessLayer() {}
	
	@Pointcut("execution(* info.chen.awsome.cws.web.controller..*)")
	public void inControllerAccessLayer() {}
}
