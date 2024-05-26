package com.cashrich.NewRestfulApi.Contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
/*import org.springframework.security.core.context.SecurityContextHolder;*/
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*import com.cashrich.NewRestfulApi.UserService;
*/import com.cashrich.NewRestfulApi.Repository.UserRepository;
import com.cashrich.NewRestfulApi.models.User;

@Controller
public class AppContoller {

	@Autowired
	private UserRepository repo;

	/*
	 * @Autowired private UserService userService;
	 */
	@GetMapping(value = "")
	public String getHomePage() {
		return "index";
	}

	@GetMapping(value = "/register")
	public String showSignUpForm(Model model) {
		model.addAttribute("user", new User());
		return "signup_form";
	}

	@PostMapping(value = "/process_register")
	public String rocessRegistration(User user) {

		repo.save(user);
		return "SignUp_success";
	}

	/*
	 * @PostMapping("/process_register") public ResponseEntity<?>
	 * signUp(@Validated @RequestBody User user) { if
	 * (userService.findByUsername(user.getUsername()) != null) { return
	 * ResponseEntity.badRequest().body("Username already exists"); } return
	 * ResponseEntity.ok(userService.save(user)); }
	 * 
	 * @PostMapping("/login") public ResponseEntity<?> login(@RequestBody User
	 * loginRequest) { // Spring Security handles login, so this can be used to
	 * check authenticated user return ResponseEntity.ok("Login successful"); }
	 */

	/*
	 * @PutMapping("/update") public ResponseEntity<?> updateUser(@RequestBody User
	 * updateRequest) { String username = updateRequest.getUsername(); User user =
	 * userService.findByUsername(username); if (user == null) { return
	 * ResponseEntity.badRequest().body("User not found"); }
	 * 
	 * user.setFirst_name(updateRequest.getFirst_name());
	 * user.setLast_name(updateRequest.getLast_name());
	 * user.setMobile_number(updateRequest.getMobile_number()); if
	 * (updateRequest.getPassword() != null &&
	 * !updateRequest.getPassword().isEmpty()) {
	 * user.setPassword(updateRequest.getPassword()); }
	 * 
	 * return ResponseEntity.ok(userService.updateUser(user)); }
	 */

}
