package com.wmoreira.javadevn1.presentation.service.error;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * @author wellington.362@gmail.com
 */

@JsonAutoDetect

public class APIError {
    private final int status;
    private final String message;

    private APIError(int status, String message) {
	this.status = status;
	this.message = message;
    }

    public static APIError of(int status) {
	return new APIError(status, null);
    }
    public static APIError of(int status, String message) {
	return new APIError(status, message);
    }

    public String getMessage() {
	return message;
    }

    public int getStatus() {
	return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        APIError apiError = (APIError)o;

        if (status != apiError.status)
            return false;
        return !(message != null ? !message.equals(apiError.message) : apiError.message != null);

    }

    @Override
    public int hashCode() {
        int result = status;
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
    }
}