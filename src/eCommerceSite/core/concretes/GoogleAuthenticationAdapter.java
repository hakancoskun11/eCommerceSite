package eCommerceSite.core.concretes;

import eCommerceSite.GoogleAuthenticationManager;
import eCommerceSite.core.abstracts.AuthenticationService;

public class GoogleAuthenticationAdapter implements AuthenticationService{

	GoogleAuthenticationManager googleAuthenticationManager = new GoogleAuthenticationManager();
	@Override
	public void register(int id, String eMail, String password, String firstName, String lastName) {
		
		googleAuthenticationManager.register(eMail, password);
		
	}

	@Override
	public void login(String eMail, String password) {
		googleAuthenticationManager.login(eMail, password);
		
	}

}