package com.yzzzzun.proxy.pureproxy.proxy;

import org.junit.jupiter.api.Test;

import com.yzzzzun.proxy.pureproxy.proxy.code.CacheProxy;
import com.yzzzzun.proxy.pureproxy.proxy.code.ProxyPatternClient;
import com.yzzzzun.proxy.pureproxy.proxy.code.RealSubject;

public class ProxyPatternTest {

	@Test
	void noProxyTest() {
		RealSubject subject = new RealSubject();
		ProxyPatternClient client = new ProxyPatternClient(subject);

		client.execute();
		client.execute();
		client.execute();
	}

	@Test
	void proxyTest() {
		RealSubject subject = new RealSubject();
		CacheProxy proxy = new CacheProxy(subject);
		ProxyPatternClient client = new ProxyPatternClient(proxy);

		client.execute();
		client.execute();
		client.execute();
	}
}
