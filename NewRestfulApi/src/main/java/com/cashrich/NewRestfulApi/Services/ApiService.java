package com.cashrich.NewRestfulApi.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.cashrich.NewRestfulApi.Repository.ApiRepository;
import com.cashrich.NewRestfulApi.models.ApiRequestResponseBean;

import java.time.LocalDateTime;

@Service
public class ApiService {

    @Autowired
    private ApiRepository repository;

    @Autowired
    private WebClient.Builder webClientBuilder;

    public ApiRequestResponseBean callThirdPartyApi(Long userId, String requestPayload, String thirdPartyUrl,String header) {
        
    	String responsePayload=null;
    	
    	try {
    		 responsePayload = webClientBuilder.build()
                    .post()
                    .uri(thirdPartyUrl)
                    .bodyValue(requestPayload)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
    		
		} catch (Exception e) {
			System.out.println("Expection from server :"+e);
		} 	
    	
    	ApiRequestResponseBean record = new ApiRequestResponseBean();
        record.setUserId(userId);
        record.setRequestPayload(requestPayload);
        record.setTimestamp(LocalDateTime.now());
		  record.setResponsePayload(responsePayload);
		  return  repository.save(record);
    	  
    }
}

