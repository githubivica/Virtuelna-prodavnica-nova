package validacija;

import java.util.ArrayList;
import java.util.List;

public class UserValidacija {
	
	public List<String> urediKolicinu(String[]kolicina){		//pravi listu tako sto izbacuje nule

		List<String> listakolicine = new ArrayList<String>();

		for(int i = 0; i<kolicina.length;i++) {
			if(!(kolicina[i].equals("0"))) {
				listakolicine.add(kolicina[i]);
			}
		}
		return listakolicine;
	}
}
