package com.yzzzzun.advanced;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.yzzzzun.advanced.trace.logtrace.LogTrace;
import com.yzzzzun.advanced.trace.logtrace.ThreadLocalLogTrace;

@Configuration
public class LogTraceConfig {

	@Bean
	public LogTrace logTrace() {
		return new ThreadLocalLogTrace();
	}
}
