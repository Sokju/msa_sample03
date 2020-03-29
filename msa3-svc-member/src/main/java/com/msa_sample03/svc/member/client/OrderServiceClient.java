package com.msa_sample03.svc.member.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderServiceClient {

	private final Logger log = LoggerFactory.getLogger(getClass());
	
    private final RestTemplate restTemplate;

    public OrderServiceClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

	public void order(String member) {
        this.restTemplate.postForObject("http://msa3-svc-order:9092/order", member, String.class);
    }

    private void getFallbackName(String member) {
        log.error("Error during call order for member: {}", member);
    }
}