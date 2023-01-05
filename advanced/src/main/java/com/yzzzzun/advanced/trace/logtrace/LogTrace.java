package com.yzzzzun.advanced.trace.logtrace;

import com.yzzzzun.advanced.trace.TraceStatus;

public interface LogTrace {
	TraceStatus begin(String message);

	void end(TraceStatus status);

	void exception(TraceStatus status, Exception e);
}
