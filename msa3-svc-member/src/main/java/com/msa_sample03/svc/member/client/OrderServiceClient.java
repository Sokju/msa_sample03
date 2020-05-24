package com.msa_sample03.svc.member.client;

import static org.springframework.util.ReflectionUtils.rethrowRuntimeException;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.msa_sample03.svc.member.domain.Member;

@Service
public class OrderServiceClient {

	private final Logger log = LoggerFactory.getLogger(getClass());
	
    private final RestTemplate restTemplate;
    
    public OrderServiceClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

	public Member order(String memberName) {
	
		ResponseEntity<String> response = null;
		ObjectMapper objectMapper = new ObjectMapper();
		Member member = new Member();
	    
		Map<String, Object> params = new HashMap<>();
		params.put("orderName"	, 	"001");
		params.put("memberName"	,	memberName);
				
		HttpHeaders headers = new HttpHeaders(); 
		headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));	//JSON 변환 
		//headers.add("Authorization", "bearer " + token); //Authorization 설정

		try
		{
			
			String requestBody = objectMapper.writeValueAsString(params);
			
			HttpEntity<String> requestEntity = new HttpEntity<String>(requestBody, headers);
			response = restTemplate.exchange("http://msa3-svc-order:9092/order", HttpMethod.POST, requestEntity, String.class);
			
			JsonNode tnode = new ObjectMapper().readTree(response.getBody().toString());
			
			member.setName(memberName);
			member.setComment(tnode.path("memberComment").asText());
			
		}
		catch (IOException e)
		{
            rethrowRuntimeException(e);
        } 
		
		return member;
    }

    private void getFallbackName(String member) {
        log.error("Error during call order for member: {}", member);
    }
}