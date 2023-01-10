package com.yzzzzun.proxy.cglib;

import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Enhancer;

import com.yzzzzun.proxy.cglib.code.TimeMethodInterceptor;
import com.yzzzzun.proxy.common.ConcreteService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CglibTest {

	@Test
	void cgLib() {
		ConcreteService target = new ConcreteService();

		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(ConcreteService.class);
		enhancer.setCallback(new TimeMethodInterceptor(target));
		ConcreteService proxy = (ConcreteService)enhancer.create();

		log.info("targetClass={}", target.getClass());
		log.info("proxyClass={}", proxy.getClass());

		proxy.call();
	}
}
