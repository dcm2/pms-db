package project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import project.entities.*;

public interface UserRepository extends JpaRepository<User, Long>{

	// Saves a User in the db
	User save(User user);
	
	// Deletes a User from the db
	void delete(User user);
	
	
	// To look for a user by its name
	@Query(value= "SELECT p FROM User p WHERE p.userName = ?1")
	User findByName(String userName);
	
	// To find the password of a particular user
	@Query(value= "SELECT p.password FROM User p WHERE p.userName = ?1")
	String findUserPw(String userName);
	
	
	
}
