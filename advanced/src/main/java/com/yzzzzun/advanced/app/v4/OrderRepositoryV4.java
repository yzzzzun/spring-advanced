package com.yzzzzun.advanced.app.v4;

import org.springframework.stereotype.Repository;

import com.yzzzzun.advanced.trace.logtrace.LogTrace;
import com.yzzzzun.advanced.trace.template.AbstractTemplate;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV4 {

	private final LogTrace trace;

	public void save(String itemId) {

		AbstractTemplate<Void> template = new AbstractTemplate<Void>(trace) {
			@Override
			protected Void call() {
				sleep(1000);
				return null;
			}
		};
		template.execute("OrderRepository.save()");
	}

	private void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
