package info.chen.awsome.cws.web.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SystemArchitecture {

	@Pointcut("within(info.chen.awsome.cws.persist.dao..*)")
	public void inDataAccessLayer() {}
	
	@Pointcut("within(info.chen.awsome.cws.service..*)")
	public void inServiceAccessLayer() {}
	
	@Pointcut("within(info.chen.awsome.cws.web.controller..*)")
	public void inControllerAccessLayer() {}
}
