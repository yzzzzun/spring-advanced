package com.yzzzzun.proxy.cglib.code;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeMethodInterceptor implements MethodInterceptor {

	private Object target;

	public TimeMethodInterceptor(Object target) {
		this.target = target;
	}

	@Override
	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
		log.info("TimeProxy 실행");
		long startTime = System.currentTimeMillis();

		Object result = methodProxy.invoke(target, objects);

		long endTime = System.currentTimeMillis();
		long resultTime = endTime - startTime;
		log.info("TimeProxy 종료 resultTime={}ms", resultTime);
		return result;

	}
}
