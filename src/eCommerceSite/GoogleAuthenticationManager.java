package eCommerceSite;

public class GoogleAuthenticationManager {

	public void register(String eMail, String password) {
		System.out.println("Google Kaydi tamamlandi: "+ eMail);
	}
	
	public void login(String eMail, String password) {
		System.out.println("Google ile login islemi gerceklesti: "+ eMail);
	}
}
