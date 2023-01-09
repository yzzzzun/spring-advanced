package com.yzzzzun.proxy.pureproxy.decorator;

import org.junit.jupiter.api.Test;

import com.yzzzzun.proxy.pureproxy.decorator.code.Component;
import com.yzzzzun.proxy.pureproxy.decorator.code.DecoratorPatternClient;
import com.yzzzzun.proxy.pureproxy.decorator.code.MessageDecorator;
import com.yzzzzun.proxy.pureproxy.decorator.code.RealComponent;
import com.yzzzzun.proxy.pureproxy.decorator.code.TimeDecorator;

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

	@Test
	void decorator2() {
		Component realComponent = new RealComponent();
		MessageDecorator messageDecorator = new MessageDecorator(realComponent);
		TimeDecorator timeDecorator = new TimeDecorator(messageDecorator);
		DecoratorPatternClient client = new DecoratorPatternClient(timeDecorator);
		client.execute();
	}
}
