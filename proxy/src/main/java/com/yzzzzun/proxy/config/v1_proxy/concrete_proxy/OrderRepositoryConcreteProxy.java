package com.yzzzzun.proxy.config.v1_proxy.concrete_proxy;

import com.yzzzzun.proxy.app.v2.OrderRepositoryV2;
import com.yzzzzun.proxy.trace.TraceStatus;
import com.yzzzzun.proxy.trace.logtrace.LogTrace;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderRepositoryConcreteProxy extends OrderRepositoryV2 {
	private final OrderRepositoryV2 target;
	private final LogTrace logTrace;

	@Override
	public void save(String itemId) {
		TraceStatus status = null;
		try {
			status = logTrace.begin("OrderRepository.request()");

			target.save(itemId);
			logTrace.end(status);
		} catch (Exception e) {
			logTrace.exception(status, e);
		}
	}

}
