package com.prashant.workorderdetails.models;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name="orderdetails", uniqueConstraints = { @UniqueConstraint(columnNames = { "workOrderId" }) })
public class OrderDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(unique=true)
	private String workOrderId;
	private String rd;
	private String material;
	private String pressureRange;
	private double materialThickness;
	private double bulgeLoad;
	private double bulgePressure;
	private double burstPressure;
	private double millDepth;
	private double topRing;
	private Date createdOn;
	private String createdBy;
	@Column(columnDefinition = "TEXT")
	private String remarks;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
}
