package com.yzzzzun.proxy.config.v2_dynamicproxy.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.springframework.util.PatternMatchUtils;

import com.yzzzzun.proxy.trace.TraceStatus;
import com.yzzzzun.proxy.trace.logtrace.LogTrace;

public class LogTraceFilterHandler implements InvocationHandler {

	private final Object target;
	private final LogTrace logTrace;
	private final String[] patterns;

	public LogTraceFilterHandler(Object target, LogTrace logTrace, String[] patterns) {
		this.target = target;
		this.logTrace = logTrace;
		this.patterns = patterns;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		String methodName = method.getName();
		if (!PatternMatchUtils.simpleMatch(patterns, methodName)) {
			return method.invoke(target, args);
		}
		TraceStatus status = null;
		try {
			String message = method.getDeclaringClass().getSimpleName() + "." + method.getName() + "()";
			status = logTrace.begin(message);

			Object result = method.invoke(target, args);
			logTrace.end(status);
			return result;
		} catch (Exception e) {
			logTrace.exception(status, e);
			throw e;
		}
	}
}
