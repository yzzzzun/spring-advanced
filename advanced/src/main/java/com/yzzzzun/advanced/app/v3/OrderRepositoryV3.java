package com.yzzzzun.advanced.app.v3;

import org.springframework.stereotype.Repository;

import com.yzzzzun.advanced.trace.TraceStatus;
import com.yzzzzun.advanced.trace.logtrace.LogTrace;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV3 {

	private final LogTrace logTrace;

	public void save(String itemId) {

		TraceStatus status = null;
		try {
			status = logTrace.begin("OrderRepository.save()");
			if (itemId.equals("ex")) {
				throw new IllegalStateException("예외 발생!");
			}
			sleep(1000);
			logTrace.end(status);
		} catch (Exception e) {
			logTrace.exception(status, e);
			throw e;
		}
	}

	private void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
