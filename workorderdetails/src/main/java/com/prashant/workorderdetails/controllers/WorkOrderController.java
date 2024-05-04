package com.prashant.workorderdetails.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.prashant.workorderdetails.models.OrderDetailDTO;
import com.prashant.workorderdetails.models.OrderDetails;
import com.prashant.workorderdetails.models.SearchWorkOrderDetailsDTO;
import com.prashant.workorderdetails.services.workOrderRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/workorders")
 public class WorkOrderController {
	
	@Autowired
	private workOrderRepository repo;
	
	
	@GetMapping  ({"","/"})
	public String welcomePage(Model model) {
//		List<OrderDetails> orderDetails = repo.findAll(Sort.by(Sort.Direction.DESC, "createdOn"));
//		OrderDetails orderDetails = repo.findByWorkOrderId("675");
//		model.addAttribute("orderDetails",orderDetails);
		return "orderDetails/index";
	} 
	
	
	@GetMapping  ({"/create"})
	public String showCreatePage(Model model) {
		OrderDetailDTO orderDetailDto = new OrderDetailDTO();
		model.addAttribute("orderDetailDto",orderDetailDto);
		return "orderDetails/CreateOrderDetail";
	} 

	@PostMapping("/create")
	public String createWorkOrder(
			@Valid @ModelAttribute("orderDetailDto") OrderDetailDTO orderDetailDto,
			BindingResult result, Model model)
	{
		if(result.hasErrors()) {
			return "orderDetails/CreateOrderDetail";
		}
		
		OrderDetails orderdetails =new OrderDetails();
		
		orderdetails.setWorkOrderId(orderDetailDto.getWorkOrderId());
		orderdetails.setRd(orderDetailDto.getRd());
		orderdetails.setMaterial(orderDetailDto.getMaterial());
		orderdetails.setPressureRange(orderDetailDto.getPressureRange());
		orderdetails.setMaterialThickness(orderDetailDto.getMaterialThickness());
		orderdetails.setBulgeLoad(orderDetailDto.getBulgeLoad());
		orderdetails.setBulgePressure(orderDetailDto.getBulgePressure());
		orderdetails.setBurstPressure(orderDetailDto.getBurstPressure());
		orderdetails.setMillDepth(orderDetailDto.getMillDepth());
		orderdetails.setTopRing(orderDetailDto.getTopRing());
		orderdetails.setRemarks(orderDetailDto.getRemarks());
		Date createdOn = new Date();
		orderdetails.setCreatedOn(createdOn);
		orderdetails.setCreatedBy(System.getenv("USERNAME")); 
		
		try {
			repo.save(orderdetails);
			model.addAttribute("resultMessage","Successfully inserted "+orderDetailDto.getWorkOrderId());
			model.addAttribute("status","success");
			
		} catch (Exception e) {
			// TODO: handle exception
			
//			System.out.println("----"+e.getMessage()+"----"+e.getLocalizedMessage());
			model.addAttribute("status","failure");
			model.addAttribute("resultMessage","Work Order already exists.");
			
			
//			return "redirect:/workorders";
		}
		return "orderDetails/CreateOrderDetail";
	}
			
	
	@GetMapping  ({"/search"})
	public String showSearchOrder(Model model) {

		SearchWorkOrderDetailsDTO searchWorkOrderDetailDto = new SearchWorkOrderDetailsDTO();
		model.addAttribute("status","failure");
		model.addAttribute("searchWorkOrderDetailDto",searchWorkOrderDetailDto);
		
		return "orderDetails/search";
	}
	@PostMapping  ({"/search"})
	public String showWorkOrderList(@Valid @ModelAttribute("searchWorkOrderDetailDto") SearchWorkOrderDetailsDTO searchWorkOrderDetailDto,
			BindingResult result, Model model) {
		
//		OrderDetails orderdetails =new OrderDetails();
//		orderdetails.setWorkOrderId(searchWorkOrderDetailDto.getWorkOrderId());

		try {
			String workOrderId=searchWorkOrderDetailDto.getWorkOrderId();
			OrderDetails orderDetails = repo.findByWorkOrderId(workOrderId);
			if(orderDetails==null) {
				model.addAttribute("status","failure");
				model.addAttribute("resultMessage","Word Order does not exist");

			}
			else {
			model.addAttribute("status","success");
			model.addAttribute("orderDetails",orderDetails);
			model.addAttribute("resultMessage","Work Order Details fetched Successfully.");	
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("status","failure");
			model.addAttribute("resultMessage",e.getMessage());			
		}
		
		
		return "orderDetails/search";
	}
	
}
