package eCommerceSite.dataAccess.abstracts;

import java.util.List;

import eCommerceSite.entities.concretes.User;

public interface UserDao {
	void add(User user);
	void update(User user);
	void delete(User user);
	
	User findById(int id);
	User findByEmail(String eMail);
	User findByEmailPassword(String aMail, String password);
	
	List<User> getAll();
}

