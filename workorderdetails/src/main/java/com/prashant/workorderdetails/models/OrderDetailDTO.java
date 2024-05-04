package com.prashant.workorderdetails.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public class OrderDetailDTO {
	
	@NotEmpty(message="Work Order is required")
	private String workOrderId;
	
	@NotEmpty(message="Rd is required")
	private String rd;
	
	@NotEmpty(message="Material is required")
	private String material;
	
	@NotEmpty(message="Pressure Range is required")
	private String pressureRange;
	
	@Min((long) -10.00)
	private double materialThickness;
	
	@Min((long) -10.00)
	private double bulgeLoad;
	
	@Min((long) -10.00)
	private double bulgePressure;
	
	@Min((long) -10.00)
	private double burstPressure;
	
	@Min((long) -10.00)
	private double millDepth;
	
	@Min((long) -10.00)
	private double topRing;
	
//	private Date createdOn;
//	private String createdBy;
//	@Column(columnDefinition = "TEXT")
	private String remarks;
	
	public String getWorkOrderId() {
		return workOrderId;
	}

	public void setWorkOrderId(String workOrderId) {
		this.workOrderId = workOrderId;
	}

	public String getRd() {
		return rd;
	}

	public void setRd(String rd) {
		this.rd = rd;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getPressureRange() {
		return pressureRange;
	}

	public void setPressureRange(String pressureRange) {
		this.pressureRange = pressureRange;
	}

	public double getMaterialThickness() {
		return materialThickness;
	}

	public void setMaterialThickness(double materialThickness) {
		this.materialThickness = materialThickness;
	}

	public double getBulgeLoad() {
		return bulgeLoad;
	}

	public void setBulgeLoad(double bulgeLoad) {
		this.bulgeLoad = bulgeLoad;
	}

	public double getBulgePressure() {
		return bulgePressure;
	}

	public void setBulgePressure(double bulgePressure) {
		this.bulgePressure = bulgePressure;
	}

	public double getBurstPressure() {
		return burstPressure;
	}

	public void setBurstPressure(double burstPressure) {
		this.burstPressure = burstPressure;
	}

	public double getMillDepth() {
		return millDepth;
	}

	public void setMillDepth(double millDepth) {
		this.millDepth = millDepth;
	}

	public double getTopRing() {
		return topRing;
	}

	public void setTopRing(double topRing) {
		this.topRing = topRing;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	

}
