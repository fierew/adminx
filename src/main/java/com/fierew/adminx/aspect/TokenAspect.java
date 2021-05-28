package com.fierew.adminx.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author xuyang
 */
@Aspect
@Component
public class TokenAspect {
    /**
     * 定义切入点，切入点为com.example.demo.aop.AopController中的所有函数
     * 通过@Pointcut注解声明频繁使用的切点表达式
     */
    @Pointcut("execution( * com.fierew.adminx.controller..*.*(..)) || " +
            "execution(public * com.fierew.adminx.controller..*.*(..))"
    )
    public void brokerAspect() {
    }

    /**
     * 使用环绕通知
     *
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("brokerAspect()")
    public Object doAroundGameData(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            System.out.println("131231231");
            //进入controller层前
            beforePoint(joinPoint);
            //放行
            Object result = joinPoint.proceed();
            //返回数据前
            afterPoint(joinPoint, result);

            return result;
        } catch (RuntimeException e) {
            return "系统异常";
        }
    }

    /**
     * @param joinPoint
     * @throws Exception
     */
    private void beforePoint(ProceedingJoinPoint joinPoint) throws Exception {
        System.out.println("进入控制器");
    }

    private void afterPoint(ProceedingJoinPoint joinPoint, Object result) throws Exception {
        System.out.println("控制器返回");
    }
}
