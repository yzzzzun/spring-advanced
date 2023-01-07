package com.yzzzzun.advanced.trace.strategy;

import org.junit.jupiter.api.Test;

import com.yzzzzun.advanced.trace.strategy.code.template.TimeLogTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TemplateCallBackTest {

	@Test
	void callBackV1() {
		TimeLogTemplate template = new TimeLogTemplate();
		template.execute(() -> log.info("비즈니스 실행 1"));
		template.execute(() -> log.info("비즈니스 실행 2"));
	}
}
