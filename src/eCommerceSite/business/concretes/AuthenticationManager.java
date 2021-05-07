package eCommerceSite.business.concretes;

import eCommerceSite.business.abstracts.EmailService;
import eCommerceSite.business.abstracts.UserService;
import eCommerceSite.business.abstracts.ValidationService;
import eCommerceSite.core.abstracts.AuthenticationService;
import eCommerceSite.core.utils.BusinessRule;
import eCommerceSite.entities.concretes.User;

public class AuthenticationManager implements AuthenticationService{
	ValidationService validationService;
	UserService userService;
	EmailService emailService;
	public AuthenticationManager(ValidationService validationService, UserService userService,
			EmailService emailService) {
		
		this.validationService = validationService;
		this.userService = userService;
		this.emailService = emailService;
	}

	@Override
	public void register(int id, String eMail, String password, String name, String lastName) {
		
		User registerUser = new User(id, name, lastName, eMail, password, false);
		
		if(!validationService.validate(registerUser)) {
			System.out.println("Dogrulama Basarisiz... Tum Bilgilerinizi Kontrol Ediniz...");
			return;
		}
		if(!BusinessRule.run(checkUserMail(eMail))) {
			System.out.println("Sistem Bulunan Bir E-Posta Adresiyle Kayit Olamazsiniz!");
			return; // 
		}
		
		System.out.println("<------Kayit Islemi Basariyla Gerceklesti------>");
		emailService.sendTo(" Daogrulama Maili Gonderilmistir... Lutfen Gelen kutunuzu Kontrol Edin", registerUser.geteMail());
		userService.add(registerUser);
	}

	@Override
	public void login(String eMail, String password) {
		if(!BusinessRule.run(checkFieldsfield(eMail, password))) {
			System.out.println("Gerekli Alanlari Doldurmaniz Gerekiyor");
			return;
		}
			User userLogin = userService.findByEmailPassword(eMail, password);
			
			if (userLogin == null) {
				System.out.println("Yanlis veya Eksik giris yaptiniz");
				return;
			}
			if(!checkUser(userLogin)) {
				System.out.println("Dogrulanmamis Hesap");
				return;
			}
			
			System.out.println("Basariyla Giris Yaptiniz..." + userLogin.geteMail() + " "+userLogin.getName());
		}
		
	
	private boolean checkUserMail(String email) {
		
		return userService.findByEmail(email) == null;
	}
	
	private boolean checkFieldsfield(String eMail,String password) {
		if(eMail.length()<=0 || password.length() <=0) {
			return false;
		}
		return true;
	}
	private boolean checkUser(User user) {
		return user.isCheck();
	}
}

