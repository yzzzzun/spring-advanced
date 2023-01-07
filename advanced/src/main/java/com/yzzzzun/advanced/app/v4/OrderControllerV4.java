package com.yzzzzun.advanced.app.v4;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yzzzzun.advanced.trace.logtrace.LogTrace;
import com.yzzzzun.advanced.trace.template.AbstractTemplate;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class OrderControllerV4 {

	private final OrderServiceV4 orderService;

	private final LogTrace logTrace;

	@GetMapping("/v4/request")
	public String request(String itemId) {

		AbstractTemplate<String> template = new AbstractTemplate<>(logTrace) {
			@Override
			protected String call() {
				orderService.orderItem(itemId);
				return "ok";
			}
		};

		return template.execute("OrderController.request()");
	}
}
