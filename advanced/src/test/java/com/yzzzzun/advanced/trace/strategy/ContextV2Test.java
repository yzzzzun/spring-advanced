package com.yzzzzun.advanced.trace.strategy;

import org.junit.jupiter.api.Test;

import com.yzzzzun.advanced.trace.strategy.code.strategy.ContextV2;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ContextV2Test {

	@Test
	void strategyV1() {
		ContextV2 context = new ContextV2();
		context.execute(() -> log.info("비즈니스 1 실행"));
		context.execute(() -> log.info("비즈니스 2 실행"));
	}

}
