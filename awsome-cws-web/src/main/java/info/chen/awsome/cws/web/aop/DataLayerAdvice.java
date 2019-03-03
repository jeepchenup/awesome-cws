package info.chen.awsome.cws.web.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class DataLayerAdvice {
	
	private static final Logger Logger = LogManager.getLogger(DataLayerAdvice.class);

	@Around("info.chen.awsome.cws.web.aop.SystemArchitecture.inDataAccessLayer()")
	public Object calculateDataAccessTime(ProceedingJoinPoint point) throws Exception {
		try {
			long start = System.currentTimeMillis();
			Object obj = point.proceed();
			long elapsedTime = System.currentTimeMillis() - start;
			Logger.info("retrive data time : {} milliseconds.", elapsedTime);
			return obj;
		} catch (Throwable e) {
			Logger.error("retrieve data failed");
			throw new Exception();
		}
	}
}
