package validacija;

import admin.Admin;

public class ValidacijaZaRegistraciju {

											//proverava da li je dobro ponovio password
	public static boolean proveraPasworda (String password, String repeatPassword) {

		if (password.equals(repeatPassword)) {
			return true;
		}
		else {
			return false;
		}
	}
											//proverava da li je admin i daje mu ulogu - rolu
	public static boolean daLiJeAdmin(String userName, String password) {
		Admin admin = new Admin();
			if(userName.equals(admin.getAdminUserName()) && password.equals(admin.getAdminPassword())) {
				return true;
			}else {
				return false;
			}
	}

}