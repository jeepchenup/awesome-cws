package info.chen.awsome.cws.web.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@Aspect
public class DataLayerAdvice {
	
	private static Logger Logger = LoggerFactory.getLogger(DataLayerAdvice.class);

	@Around("info.chen.awsome.cws.web.aop.SystemArchitecture.inDataAccessLayer()")
	public Object calculateDataAccessTime(ProceedingJoinPoint point) {
		try {
			long start = System.currentTimeMillis();
			Object obj = point.proceed();
			long elapsedTime = System.currentTimeMillis() - start;
			Logger.info("takes {} milliseconds to retrive data", elapsedTime);
			return obj;
		} catch (Throwable e) {
			Logger.error("retrieve data failed");
		}
		return null;
	}
}
