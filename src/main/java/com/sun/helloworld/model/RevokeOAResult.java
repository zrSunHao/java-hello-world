package com.sun.helloworld.model;

public class RevokeOAResult {
	
	public String data;

    public String errorMessage ;

    public Boolean hasErrors ;
    
    public Boolean success ;

    public RevokeOAResult()
    {
        this.success = true;
        
        this.hasErrors = false;
    }

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Boolean getHasErrors() {
		return hasErrors;
	}

	public void setHasErrors(Boolean hasErrors) {
		this.hasErrors = hasErrors;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}
}
