package eCommerceSite.core.utils;



public class ValidationRule {
	 public static boolean run(boolean... logics) {
    	 for(boolean logic : logics) {
    		 if(!logic) return false;
    	 }
    	 return true;
     }

}