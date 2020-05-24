package com.msa_sample03.svc.order.controller;

import static org.springframework.util.ReflectionUtils.rethrowRuntimeException;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.msa_sample03.svc.order.domain.OrderCVO;
import com.msa_sample03.svc.order.service.OrderService;

@RestController
public class OrderRestController {
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value = "/order", method = RequestMethod.POST)
	public ResponseEntity<OrderCVO> order(@RequestBody OrderCVO orderCVO) {

		try
		{
			//member service 호출
//			HttpHeaders headers = new HttpHeaders(); 
//			headers.setContentType(MediaType.APPLICATION_JSON);	//JSON 변환 
//			//headers.set("Authorization", "token key"); //Authorization 설정
//	
//			HttpEntity entity = new HttpEntity("parameters", headers); 
//			
//			ResponseEntity response= restTemplate.exchange(String.format("http://msa3-svc-member:9091/member/%s", orderCVO.getMemberName())
//															,	HttpMethod.GET
//															, 	entity
//															, 	String.class);
//			
//			JsonNode tnode = new ObjectMapper().readTree(response.getBody().toString());
//			
//			log.debug(response.getBody().toString());
//
//			JsonNode jnode = null;
	        
	        
			//order
			orderCVO	=	orderService.order(orderCVO);
			
		}
		catch (Exception e) 
		{
            rethrowRuntimeException(e);
        } 
		
		return new ResponseEntity<OrderCVO>(orderCVO, HttpStatus.OK);
	}
}
