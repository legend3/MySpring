package org.legend.aop;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component("logAfter")
public class LogAfter implements AfterReturningAdvice {//实现接口
    @Override
    public void afterReturning(Object object, Method method, Object[] parameters, Object returnObject) throws Throwable {
        System.out.println("*****后置通知*******" + "\n目标对象：" + object + "\n目标方法：" + method + "\n目标方法参数个数：" + parameters.length + "\n目标方法返回值: " + returnObject);
    }
}
