package com.cashrich.NewRestfulApi.Contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cashrich.NewRestfulApi.Services.ApiService;
import com.cashrich.NewRestfulApi.models.ApiRequestResponseBean;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private ApiService apiService;
    
String header = "X-CMC_PRO_API_KEY";
    @PostMapping("/call")
    public ResponseEntity<ApiRequestResponseBean> callThirdPartyApi(@RequestParam Long userId,
                                                                @RequestBody String requestPayload,
                                                                @RequestParam String thirdPartyUrl,
                                                                @RequestHeader String header) {
    	ApiRequestResponseBean response = apiService.callThirdPartyApi(userId, requestPayload, thirdPartyUrl,header);
        return ResponseEntity.ok(response);
    }
}
