package eCommerceSite.core.abstracts;

public interface AuthenticationService {
	void register(int id, String eMail, String password, String firstName,String lastName);
	void login(String eMail, String password);
}
