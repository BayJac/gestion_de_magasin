package application;

import gestionnaire_magasin.Magasin;
import rayon.Rayon;

public class Test {
	public static void main(String[] args) {
		Rayon r1 = new Rayon("boisson","pepsi 400ml","bullet 350ml","buffalo 0.5l","bullet 350ml","bullet 350ml","coca-cola 1l","sprite 400ml");
		Rayon r2 = new Rayon("boisson","djino 1l","pamplemousse 1l","orangina 1l","coca-cola 1l","grenadine 1l","coca-cola 1l");
		Rayon r3 = new Rayon("epice","");
		Magasin m = new Magasin("Chez MAGI", r1,r2,r3);
		m.start();
	}
}