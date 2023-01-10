package com.yzzzzun.proxy.jdkdynamic;

import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReflectionTest {

	@Test
	void reflection0() {
		Hello target = new Hello();

		//공통로직1
		log.info("start");
		String result1 = target.callA();
		log.info("result={}", result1);

		//공통로직2
		log.info("start");
		String result2 = target.callB();
		log.info("result={}", result2);

	}

	@Test
	void reflection1() throws Exception {
		Class classHello = Class.forName("com.yzzzzun.proxy.jdkdynamic.ReflectionTest$Hello");
		Hello target = new Hello();

		Method methodCallA = classHello.getMethod("callA");
		dynamicCall(methodCallA, target);

		Method methodCallB = classHello.getMethod("callB");
		dynamicCall(methodCallB, target);
	}

	private void dynamicCall(Method method, Object target) throws Exception {
		log.info("start");
		Object result = method.invoke(target);
		log.info("result={}", result);
	}

	static class Hello {
		public String callA() {
			log.info("call A");
			return "A";
		}

		public String callB() {
			log.info("call B");
			return "B";
		}
	}

}
