package com.prashant.workorderdetails.models;

import jakarta.validation.constraints.NotEmpty;

public class SearchWorkOrderDetailsDTO {

	@NotEmpty(message="Work Order is required")
	private String workOrderId;

	public String getWorkOrderId() {
		return workOrderId;
	}

	public void setWorkOrderId(String workOrderId) {
		this.workOrderId = workOrderId;
	}
	
	
	
}
