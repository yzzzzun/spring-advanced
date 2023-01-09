package com.yzzzzun.proxy.config.v1_proxy.interface_proxy;

import com.yzzzzun.proxy.app.v1.OrderControllerV1;
import com.yzzzzun.proxy.trace.TraceStatus;
import com.yzzzzun.proxy.trace.logtrace.LogTrace;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderControllerInterfaceProxy implements OrderControllerV1 {

	private final OrderControllerV1 target;
	private final LogTrace logTrace;

	@Override
	public String request(String itemId) {

		TraceStatus status = null;
		try {
			status = logTrace.begin("OrderRepository.request()");
			String result = target.request(itemId);
			logTrace.end(status);
			return result;
		} catch (Exception e) {
			logTrace.exception(status, e);
			throw e;
		}
	}

	@Override
	public String noLog() {
		return target.noLog();
	}
}
