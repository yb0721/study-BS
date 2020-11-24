package aop;

import java.util.logging.Logger;

import com.sun.jmx.snmp.Timestamp;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component("loggerAdvice")
public class LoggerAdvice {
    Logger logger = Logger.getLogger("LoggerAdvice.class");

    @Before(value = "execution(* service.impl..*.*(..))")
    public void methodBefore(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        if ("login".equals(method)) {
            logger.info(new Timestamp(System.currentTimeMillis()) + "" + args[0] + "开始登录！");
        }
    }

    @AfterReturning(pointcut = "execution(* service.impl..*.*(..))", returning = "ret")
    public void afterReturning(JoinPoint joinPoint, Object ret) {
        String method = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        if("login".equals(method)) {
            if(ret != null) {
                logger.info(new Timestamp(System.currentTimeMillis()) + "" + args[0] + "登录成功！");
            }
            else {
                logger.info(new Timestamp(System.currentTimeMillis()) + "" + args[0] + "登录失败！");
            }
        }
        
    }
}