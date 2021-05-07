package eCommerceSite.business.concretes;

import java.util.List;

import eCommerceSite.business.abstracts.UserService;
import eCommerceSite.dataAccess.abstracts.UserDao;
import eCommerceSite.entities.concretes.User;

public class UserManager implements UserService {
	private UserDao userDao;
	

	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public void add(User user) {
		userDao.add(user);
		
	}

	@Override
	public void update(User user) {
		userDao.update(user);
		
	}

	@Override
	public void remove(User user) {
		userDao.delete(user);
		
	}

	@Override
	public void verifyUser(int id) {
		User user = userDao.findById(id);
		user.setCheck(true);
		System.out.println("Doðrulama iþlemi gerçekleþtirildi.");
		
	}

	@Override
	public User find(int id) {
		
		return userDao.findById(id);
	}

	@Override
	public User findByEmail(String email) {
		
		return userDao.findByEmail(email);
	}

	@Override
	public User findByEmailPassword(String eMail, String password) {
		
		return userDao.findByEmailPassword(eMail, password);
	}

	@Override
	public List<User> getAll() {
		
		return userDao.getAll();
	}

}
