package com.step.exception;

import com.step.dto.SeckillExecution;

public class SeckillException extends RuntimeException{
	public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}
