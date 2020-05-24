package com.msa_sample03.svc.order.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.msa_sample03.svc.order.domain.OrderCVO;

@Service
public class OrderServiceImpl implements OrderService {

	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Override
	public OrderCVO order(OrderCVO orderCVO) {
		
		log.debug("Order Service was called!!!");
		orderCVO.setMemberComment("Order Service was called");
		return orderCVO;
	}
}
