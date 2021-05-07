package eCommerceSite;


import eCommerceSite.business.abstracts.UserService;
import eCommerceSite.business.concretes.AuthenticationManager;
import eCommerceSite.business.concretes.EmailManager;
import eCommerceSite.business.concretes.UserManager;
import eCommerceSite.business.concretes.ValidationManager;
import eCommerceSite.core.abstracts.AuthenticationService;
import eCommerceSite.core.concretes.GoogleAuthenticationAdapter; 
import eCommerceSite.dataAccess.concretes.DefaultUserDao;

public class Main {

	public static void main(String[] args) {
		UserService userService = new UserManager(new DefaultUserDao());
		AuthenticationService authenticationService = new AuthenticationManager(new ValidationManager(), userService, new EmailManager());
		
		authenticationService.register(1, "hakancoskun360@gmail.com", "123123123", "Hakan", "Coskun");
		authenticationService.register(2, "hakan", "1231", "Deneme", "Kisisi");
		authenticationService.register(3, "info@gmail.com", "t", "Hakan", "yedek");
		
		
		authenticationService.login("hakancoskun360@gmail.com", "123123123");
		userService.verifyUser(1);
		
		authenticationService.login("hakan", "12123123");
		
		authenticationService.login("info@gmail.com", "123123123");
		
		authenticationService.login("", "");
		
		
		AuthenticationService googleAuth = new GoogleAuthenticationAdapter();
		googleAuth.register(6, "eda@gmail.com", "eda", "eda", "coskun");
		googleAuth.login("eda@gmail.com", "eda");

	}

}
