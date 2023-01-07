package com.yzzzzun.advanced.app.v1;

import org.springframework.stereotype.Service;

import com.yzzzzun.advanced.trace.TraceStatus;
import com.yzzzzun.advanced.trace.hellotrace.HelloTraceV1;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceV1 {
	private final OrderRepositoryV1 orderRepository;

	private final HelloTraceV1 trace;

	public void orderItem(String itemId) {
		TraceStatus status = null;
		try {
			status = trace.begin("OrderService.orderItem()");
			orderRepository.save(itemId);
			trace.end(status);
		} catch (Exception e) {
			trace.exception(status, e);
			throw e;
		}
	}
}
