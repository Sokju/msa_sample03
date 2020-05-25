package com.msa_sample03.svc.product.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.msa_sample03.svc.product.domain.Product;

@RestController
public class ProductRestController {
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public ResponseEntity<Product> getProductByName(@RequestBody Product product) {
		
		log.debug("############ getMemberByName : " + product.getMemberName());
		
		Product product2 = new Product();
		product2.setName(product.getMemberName());
		product2.setComment("Product Service was called");
		
		return new ResponseEntity<Product>(product2, HttpStatus.OK);
	}
	
	public Product fallbackProductByName(@RequestBody Product product) {
		
		log.debug("############ fallbackMemberByName : " + product.getMemberName());
		
		Product product2 = new Product();
		product2.setName(product.getMemberName());
		product2.setComment("fallbackMemberByName");
		return product2;
	}
	
}
