package com.acms.exception.handler;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.acms.exception.BadRequestException;
import com.acms.model.ErrorTO;
import com.acms.model.ExceptionTO;

@Provider
public class ExceptionHandler implements ExceptionMapper<Exception> {
	private final Logger logger = LoggerFactory.getLogger(getClass());

	public Response toResponse(Exception ex) {
		logger.error("An exception occurred with message: {}", buildErrorMessage(ex));

		String exMsg;
		Status status;

		if (ex instanceof BadRequestException) {
			status = Status.BAD_REQUEST;

			exMsg = ex.getMessage();
		} else {
			status = Status.INTERNAL_SERVER_ERROR;

			exMsg = Status.INTERNAL_SERVER_ERROR.toString();
		}
		ExceptionTO response = new ExceptionTO();
		response.setError(new ErrorTO(exMsg));

		return Response.status(status).entity(response).build();
	}

	private String buildErrorMessage(Exception ex) {
		Throwable cause = ex.getCause();

		return cause == null ? ex.getMessage() : cause.getMessage();
	}
}
