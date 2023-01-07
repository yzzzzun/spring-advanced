package com.yzzzzun.advanced.app.v5;

import org.springframework.stereotype.Service;

import com.yzzzzun.advanced.trace.callback.TraceTemplate;
import com.yzzzzun.advanced.trace.logtrace.LogTrace;

@Service
public class OrderServiceV5 {
	private final OrderRepositoryV5 orderRepository;

	private final TraceTemplate traceTemplate;

	public OrderServiceV5(OrderRepositoryV5 orderRepository, LogTrace logTrace) {
		this.orderRepository = orderRepository;
		this.traceTemplate = new TraceTemplate(logTrace);
	}

	public void orderItem(String itemId) {

		traceTemplate.execute("OrderService.save()", () -> {
			if (itemId.equals("ex")) {
				throw new IllegalStateException("예외 발생!");
			}
			orderRepository.save(itemId);
			return null;
		});
	}
}
