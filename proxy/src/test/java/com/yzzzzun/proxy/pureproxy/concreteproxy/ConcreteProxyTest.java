package com.yzzzzun.proxy.pureproxy.concreteproxy;

import org.junit.jupiter.api.Test;

import com.yzzzzun.proxy.pureproxy.concreteproxy.code.ConcreteClient;
import com.yzzzzun.proxy.pureproxy.concreteproxy.code.ConcreteLogic;
import com.yzzzzun.proxy.pureproxy.concreteproxy.code.TimeProxy;

public class ConcreteProxyTest {

	@Test
	void noProxy() {
		ConcreteLogic concreteLogic = new ConcreteLogic();
		ConcreteClient client = new ConcreteClient(concreteLogic);

		client.execute();
	}

	@Test
	void addProxy() {
		ConcreteLogic concreteLogic = new ConcreteLogic();
		TimeProxy proxy = new TimeProxy(concreteLogic);
		ConcreteClient concreteClient = new ConcreteClient(proxy);
		concreteClient.execute();
	}
}
