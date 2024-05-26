package com.cashrich.NewRestfulApi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cashrich.NewRestfulApi.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query("select u from User u where u.username = ?1")
	  User findByUsername(String username);

}
