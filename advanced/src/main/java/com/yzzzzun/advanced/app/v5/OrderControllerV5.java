package com.yzzzzun.advanced.app.v5;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yzzzzun.advanced.trace.callback.TraceTemplate;
import com.yzzzzun.advanced.trace.logtrace.LogTrace;

@RestController
public class OrderControllerV5 {

	private final OrderServiceV5 orderService;
	private final TraceTemplate traceTemplate;

	public OrderControllerV5(OrderServiceV5 orderService, LogTrace logTrace) {
		this.orderService = orderService;
		this.traceTemplate = new TraceTemplate(logTrace);
	}

	@GetMapping("/v5/request")
	public String request(String itemId) {

		return traceTemplate.execute("OrderController.request()", () -> {
			orderService.orderItem(itemId);
			return "ok";
		});
	}
}
