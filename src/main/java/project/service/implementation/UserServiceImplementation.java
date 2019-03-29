package project.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import project.entities.*;
import project.repositories.UserRepository;
import project.service.UserService;


@Service
public class UserServiceImplementation implements UserService{


	// Instance Variable
	UserRepository userRepo;
	
	// Dependency Injection
	@Autowired
	public UserServiceImplementation(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	/* IMPLEMENTATION OF METHODS IN THE LandingService INTERFACE*/
	@Override
	public User save(User user) {
		System.out.println("user: " + user.getUserName() + ", has been saved correctly");
		return userRepo.save(user);
	}

	@Override
	public void delete(User user) {
		userRepo.delete(user);	
	}
	
	@Override
	public boolean isUserInDB(String name) {
		
		User prospect = new User();
		prospect = userRepo.findByName(name);
		
		if (prospect == null) {
			return false;
		}
		
		return true;		
	}
	
	@Override
	public boolean verification(UserInfo userInfo) {
		
		String prospectiveUserName = userInfo.getUserName();
		String prospectivePw = userInfo.getPassword();
		
		if(isUserInDB(prospectiveUserName)){ 
			String pwInDB = userRepo.findUserPw(prospectiveUserName);
			return prospectivePw.equals(pwInDB);
		}
		
		return false;
	}
	
	@Override
	public User findByName(String userName) {
		return userRepo.findByName(userName);
	}
	
	
}
