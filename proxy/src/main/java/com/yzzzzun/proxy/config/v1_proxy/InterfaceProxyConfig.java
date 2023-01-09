package com.yzzzzun.proxy.config.v1_proxy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.yzzzzun.proxy.app.v1.OrderControllerV1;
import com.yzzzzun.proxy.app.v1.OrderControllerV1Impl;
import com.yzzzzun.proxy.app.v1.OrderRepositoryV1;
import com.yzzzzun.proxy.app.v1.OrderRepositoryV1Impl;
import com.yzzzzun.proxy.app.v1.OrderServiceV1;
import com.yzzzzun.proxy.app.v1.OrderServiceV1Impl;
import com.yzzzzun.proxy.config.v1_proxy.interface_proxy.OrderControllerInterfaceProxy;
import com.yzzzzun.proxy.config.v1_proxy.interface_proxy.OrderRepositoryInterfaceProxy;
import com.yzzzzun.proxy.config.v1_proxy.interface_proxy.OrderServiceInterfaceProxy;
import com.yzzzzun.proxy.trace.logtrace.LogTrace;

@Configuration
public class InterfaceProxyConfig {

	@Bean
	public OrderControllerV1 orderController(LogTrace logTrace) {
		OrderControllerV1Impl orderControllerImpl = new OrderControllerV1Impl(orderService(logTrace));
		return new OrderControllerInterfaceProxy(orderControllerImpl, logTrace);
	}

	@Bean
	public OrderServiceV1 orderService(LogTrace logTrace) {
		OrderServiceV1Impl orderServiceImpl = new OrderServiceV1Impl(orderRepository(logTrace));
		return new OrderServiceInterfaceProxy(orderServiceImpl, logTrace);
	}
 
	@Bean
	public OrderRepositoryV1 orderRepository(LogTrace logTrace) {
		OrderRepositoryV1Impl orderRepositoryImpl = new OrderRepositoryV1Impl();
		return new OrderRepositoryInterfaceProxy(orderRepositoryImpl, logTrace);
	}
}
