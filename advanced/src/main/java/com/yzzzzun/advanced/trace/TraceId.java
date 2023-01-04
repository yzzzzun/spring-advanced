package com.yzzzzun.advanced.trace;

import java.util.UUID;

import lombok.Getter;

@Getter
public class TraceId {

	private String id;

	private int level;

	public TraceId() {
		this.id = createId();
		this.level = 0;
	}

	private String createId() {
		return UUID.randomUUID().toString().substring(0, 8);
	}

	public TraceId(String id, int level) {
		this.id = id;
		this.level = level;
	}

	public TraceId createNextId() {
		return new TraceId(id, level + 1);
	}

	public TraceId createPreviousId() {
		return new TraceId(id, level - 1);
	}

	public boolean isFirstLevel() {
		return level == 0;
	}
}
