package eCommerceSite.business.abstracts;

import java.util.List;

import eCommerceSite.entities.concretes.User;

public interface UserService {
	void add(User user);
	void update(User user);
	void remove(User user);
	void verifyUser(int id);
	User find(int id);
	User findByEmail(String email);
	User findByEmailPassword(String eMail, String password);
	List<User> getAll();
	
	
	
}
