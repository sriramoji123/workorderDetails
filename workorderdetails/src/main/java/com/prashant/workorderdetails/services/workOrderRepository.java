package com.prashant.workorderdetails.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prashant.workorderdetails.models.OrderDetails;

public interface workOrderRepository extends JpaRepository<OrderDetails, Integer> {

	public OrderDetails findByWorkOrderId(String workOrderId);
}
