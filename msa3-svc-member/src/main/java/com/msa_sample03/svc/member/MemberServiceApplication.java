package com.msa_sample03.svc.member;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.msa_sample03.svc.member.client.OrderMsgBinding;

@SpringBootApplication
@EnableBinding(OrderMsgBinding.class)
public class MemberServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(MemberServiceApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	
//    @Bean
//    public RestTemplate restTemplate() {
//    	HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
//        httpRequestFactory.setConnectTimeout(2000);
//        httpRequestFactory.setReadTimeout(3000);
//        HttpClient httpClient = HttpClientBuilder.create()
//                .setMaxConnTotal(200)
//                .setMaxConnPerRoute(20)
//                .build();
//        httpRequestFactory.setHttpClient(httpClient);
//        return new RestTemplate(httpRequestFactory);
//    }
}
