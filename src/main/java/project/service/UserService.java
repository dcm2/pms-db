package project.service;

import project.entities.*;

public interface UserService {

	User save(User user);

	void delete(User user);
	
	boolean isUserInDB(String name);
	
	boolean verification(UserInfo userInfo);

	User findByName(String userName);
	
}










