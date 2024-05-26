package com.cashrich.NewRestfulApi.Contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cashrich.NewRestfulApi.UserService;
import com.cashrich.NewRestfulApi.models.User;


@RestController
@RequestMapping("/cashrich")
public class SignUpLoginController {
	
	@Autowired
	private UserService service;

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@Validated @RequestBody User user) {
        if (service.findByUsername(user.getUsername()) != null) {
            return ResponseEntity.badRequest().body("Username already exists");
        }
        return ResponseEntity.ok(service.save(user));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User loginRequest) {
        // Spring Security handles login, so this can be used to check authenticated user
        return ResponseEntity.ok("Login successful");
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody User updateRequest) {
       // String username = SecurityContextHolder.getContext().getAuthentication().getName();
    	String username =updateRequest.getUsername();
        User user = service.findByUsername(username);
        if (user == null) {
            return ResponseEntity.badRequest().body("User not found");
        }
        user.setFirst_name(updateRequest.getFirst_name());
        user.setLast_name(updateRequest.getLast_name());
        user.setMobile_number(updateRequest.getMobile_number());
        if (updateRequest.getPassword() != null && !updateRequest.getPassword().isEmpty()) {
            user.setPassword(updateRequest.getPassword());
        }

        return ResponseEntity.ok(service.updateUser(user));
    }

}
