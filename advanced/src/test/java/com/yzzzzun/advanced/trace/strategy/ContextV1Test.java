package com.yzzzzun.advanced.trace.strategy;

import org.junit.jupiter.api.Test;

import com.yzzzzun.advanced.trace.strategy.code.strategy.ContextV1;
import com.yzzzzun.advanced.trace.strategy.code.strategy.StrategyLogic1;
import com.yzzzzun.advanced.trace.strategy.code.strategy.StrategyLogic2;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ContextV1Test {

	@Test
	void strategyV1() {
		ContextV1 context1 = new ContextV1(new StrategyLogic1());
		ContextV1 context2 = new ContextV1(new StrategyLogic2());

		context1.execute();
		context2.execute();
	}

	@Test
	void strategyV2() {
		ContextV1 context1 = new ContextV1(() -> log.info("비즈니스 로직 1 실행"));
		ContextV1 context2 = new ContextV1(() -> log.info("비즈니스 로직 2 실행"));

		context1.execute();
		context2.execute();
	}
}
