package com.yzzzzun.proxy.pureproxy.concreteproxy.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeProxy extends ConcreteLogic {

	private final ConcreteLogic realLogic;

	public TimeProxy(ConcreteLogic realLogic) {
		this.realLogic = realLogic;
	}

	@Override
	public String operation() {
		log.info("TimeDecorator 실행");

		long startTime = System.currentTimeMillis();
		long endTime = System.currentTimeMillis();
		String result = realLogic.operation();

		long resultTime = endTime - startTime;
		log.info("TimeDecorator 종료 resultTime={}ms", resultTime);
		return result;
	}
}
