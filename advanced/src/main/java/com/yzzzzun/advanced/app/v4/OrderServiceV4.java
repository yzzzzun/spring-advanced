package com.yzzzzun.advanced.app.v4;

import org.springframework.stereotype.Service;

import com.yzzzzun.advanced.trace.logtrace.LogTrace;
import com.yzzzzun.advanced.trace.template.AbstractTemplate;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceV4 {
	private final OrderRepositoryV4 orderRepository;

	private final LogTrace trace;

	public void orderItem(String itemId) {

		AbstractTemplate<Void> template = new AbstractTemplate<Void>(trace) {
			@Override
			protected Void call() {
				orderRepository.save(itemId);
				return null;
			}
		};
		template.execute("OrderService.orderItem()");
	}
}
