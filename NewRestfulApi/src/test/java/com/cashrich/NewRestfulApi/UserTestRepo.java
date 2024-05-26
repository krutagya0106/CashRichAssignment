package com.cashrich.NewRestfulApi;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.cashrich.NewRestfulApi.Repository.UserRepository;
import com.cashrich.NewRestfulApi.models.User;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserTestRepo {

	@Autowired
	private UserRepository repo;

	@Autowired
	private TestEntityManager entitymanager;

	/*
	 * @Test public void testCreateUser() {
	 * 
	 * User user = new User(); user.setEmail("anu@gmail.com");
	 * user.setFirst_name("kd"); user.setLast_name("dm");
	 * user.setMobile_number("7785214568"); user.setPassword("kd123");
	 * user.setUsername("kd1234");
	 * 
	 * User saveduser =repo.save(user);
	 * 
	 * User existUser = entitymanager.find(User.class, saveduser.getId());
	 * 
	 * assertThat(existUser.getEmail()).isEqualTo(saveduser.getEmail());
	 * 
	 * }
	 */
	@Test
	public void testFindUserByUserName() {
		String username = "kkdd";
		User user = repo.findByUsername(username);

		assertThat(user).isNotNull();
		System.out.println("tested..");

	}
}