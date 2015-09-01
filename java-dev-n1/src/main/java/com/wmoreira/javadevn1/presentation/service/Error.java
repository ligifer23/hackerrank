package com.wmoreira.javadevn1.presentation.service;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * Created by welingtonmoreira on 01/09/15.
 */
@JsonAutoDetect
public class Error {
    private final int status;
    private final String message;

    private Error(int status, String message) {
	this.status = status;
	this.message = message;
    }

    public static Error of(int status) {
	return new Error(status, null);
    }
    public static Error of(int status, String message) {
	return new Error(status, message);
    }

    public String getMessage() {
	return message;
    }

    public int getStatus() {
	return status;
    }
}