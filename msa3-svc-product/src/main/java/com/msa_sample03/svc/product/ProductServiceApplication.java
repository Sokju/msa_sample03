package com.msa_sample03.svc.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ProductServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
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
