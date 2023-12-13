package com.acms.exception.handler;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.acms.exception.BadRequestException;
import com.acms.model.ErrorTO;
import com.acms.model.ExceptionTO;

@Provider
public class ExceptionHandler implements ExceptionMapper<Exception> {

	public Response toResponse(Exception ex) {

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

}
