package com.msa_sample03.svc.order.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.msa_sample03.svc.order.service.OrderServiceImpl;

@RestController
public class OrderRestController {
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private OrderServiceImpl orderServiceImpl;
	
	
	@RequestMapping(value = "/order", method = RequestMethod.POST)
//	public ResponseEntity<OrderCVO> order(@RequestBody OrderCVO orderCVO) {
//		
//		//order
//		orderServiceImpl.order(orderCVO);

//		
//		return new ResponseEntity<OrderCVO>(orderCVO, HttpStatus.OK);
//	}
	public void order(@RequestBody String member) {
		
		log.debug("member : {}", member);
		//order
		//orderServiceImpl.order(orderCVO);

		
	}
}
