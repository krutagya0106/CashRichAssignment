package com.cashrich.NewRestfulApi;



import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;*/
import org.springframework.stereotype.Service;

import com.cashrich.NewRestfulApi.Repository.UserRepository;
import com.cashrich.NewRestfulApi.models.User;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

	/*
	 * @Autowired private BCryptPasswordEncoder passwordEncoder;
	 */

    public User save(User user) {
        //user.setPassword(passwordEncoder.encode(user.getPassword()));
   
        return repo.save(user);
    }

    public User findByUsername(String username) {
        return repo.findByUsername(username);
    }

    public User updateUser(User user) {
        return repo.save(user);
    }
}
