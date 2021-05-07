package eCommerceSite.business.abstracts;

import eCommerceSite.entities.concretes.User;

public interface ValidationService {
	boolean validate(User user);
}
