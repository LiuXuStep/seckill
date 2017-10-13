package com.step.exception;

import com.step.dto.SeckillExecution;
/*
 * 重复秒杀异常
 */
public class RepeatKillException extends SeckillException{
	 public RepeatKillException(String message) {
	        super(message);
	    }

	    public RepeatKillException(String message, Throwable cause) {
	        super(message, cause);
	    }
}
