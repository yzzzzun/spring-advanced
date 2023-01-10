package com.yzzzzun.proxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import com.yzzzzun.proxy.config.v2_dynamicproxy.DynamicProxyFilterConfig;
import com.yzzzzun.proxy.trace.logtrace.LogTrace;
import com.yzzzzun.proxy.trace.logtrace.ThreadLocalLogTrace;

// @Import({AppV1Config.class, AppV2Config.class})
@Import({DynamicProxyFilterConfig.class})
@SpringBootApplication(scanBasePackages = "com.yzzzzun.proxy.app")
public class ProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProxyApplication.class, args);
	}

	@Bean
	public LogTrace logTrace() {
		return new ThreadLocalLogTrace();
	}
}
