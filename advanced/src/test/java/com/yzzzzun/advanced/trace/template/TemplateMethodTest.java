package com.yzzzzun.advanced.trace.template;

import org.junit.jupiter.api.Test;

import com.yzzzzun.advanced.trace.template.code.AbstractTemplate;
import com.yzzzzun.advanced.trace.template.code.SubClassLogic1;
import com.yzzzzun.advanced.trace.template.code.SubClassLogic2;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TemplateMethodTest {

	@Test
	void templateMethodVo() {
		logic1();
		logic2();
	}

	private void logic1() {
		long startTime = System.currentTimeMillis();
		log.info("비즈니스 로직 1 실행");

		long endTime = System.currentTimeMillis();
		long resultTime = endTime - startTime;
		log.info("resultTime = {}", resultTime);
	}

	private void logic2() {
		long startTime = System.currentTimeMillis();
		log.info("비즈니스 로직 2 실행");

		long endTime = System.currentTimeMillis();
		long resultTime = endTime - startTime;
		log.info("resultTime = {}", resultTime);
	}

	@Test
	void templateMethodV1() {
		AbstractTemplate subClassLogic1 = new SubClassLogic1();
		AbstractTemplate subClassLogic2 = new SubClassLogic2();

		subClassLogic1.execute();
		subClassLogic2.execute();
	}

	@Test
	void templateMethodV2() {
		AbstractTemplate template1 = new AbstractTemplate() {
			@Override
			protected void call() {
				log.info("비즈니스 로직 1 실행");
			}
		};

		AbstractTemplate template2 = new AbstractTemplate() {
			@Override
			protected void call() {
				log.info("비즈니스 로직 2 실행");
			}
		};

		log.info("클래스1 = {}", template1.getClass());
		template1.execute();
		log.info("클래스2 = {}", template2.getClass());
		template2.execute();
	}
}
