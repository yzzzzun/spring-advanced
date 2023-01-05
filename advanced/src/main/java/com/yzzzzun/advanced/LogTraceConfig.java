package com.yzzzzun.advanced;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.yzzzzun.advanced.trace.logtrace.FieldLogTrace;
import com.yzzzzun.advanced.trace.logtrace.LogTrace;

@Configuration
public class LogTraceConfig {

	@Bean
	public LogTrace logTrace() {
		return new FieldLogTrace();
	}
}
