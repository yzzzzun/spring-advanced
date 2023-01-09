package com.yzzzzun.proxy.decorator;

import org.junit.jupiter.api.Test;

import com.yzzzzun.proxy.decorator.code.Component;
import com.yzzzzun.proxy.decorator.code.DecoratorPatternClient;
import com.yzzzzun.proxy.decorator.code.MessageDecorator;
import com.yzzzzun.proxy.decorator.code.RealComponent;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DecoratorPatternTest {

	@Test
	void noDecorator() {
		Component realComponent = new RealComponent();
		DecoratorPatternClient client = new DecoratorPatternClient(realComponent);
		client.execute();
	}

	@Test
	void decorator1() {
		Component realComponent = new RealComponent();
		MessageDecorator messageDecorator = new MessageDecorator(realComponent);
		DecoratorPatternClient client = new DecoratorPatternClient(messageDecorator);
		client.execute();
	}
}
