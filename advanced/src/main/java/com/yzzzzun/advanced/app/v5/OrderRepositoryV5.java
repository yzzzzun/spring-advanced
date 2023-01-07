package com.yzzzzun.advanced.app.v5;

import org.springframework.stereotype.Repository;

import com.yzzzzun.advanced.trace.callback.TraceTemplate;
import com.yzzzzun.advanced.trace.logtrace.LogTrace;

@Repository
public class OrderRepositoryV5 {

	private final TraceTemplate traceTemplate;

	public OrderRepositoryV5(LogTrace logTrace) {
		this.traceTemplate = new TraceTemplate(logTrace);
	}

	public void save(String itemId) {

		traceTemplate.execute("OrderRepository.save()", () -> {
			sleep(1000);
			return null;
		});
	}

	private void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
