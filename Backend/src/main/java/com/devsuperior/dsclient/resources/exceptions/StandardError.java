package com.devsuperior.dsclient.resources.exceptions;

import java.time.Instant;

public class StandardError {

	/* Atributos que irão substituir o erro 500
	  {
           "timestamp": "2021-02-16T14:35:54.813+00:00",
           "status": 500,
           "error": "Internal Server Error",
           "message": "",
           "path": "/clients/10"
        }
	 */
	
	private Instant timeStamp;
	private int  status;
	private String error;
	private String message;
	private String path;
	
	public StandardError() {
		
	}

	public Instant getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Instant timeStamp) {
		this.timeStamp = timeStamp;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	
	
}
