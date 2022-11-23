package produit;

public class Epice extends Produit {

	public Epice(String nomProd) {
		super(nomProd);
		switch(nomProd) {
		case "tartina 900g" -> this.setP_U(1400);
		case "jadida 500g" -> this.setP_U(400);
		case "armanti 1kg" -> this.setP_U(850);
		case "riz neima 25kg" -> this.setP_U(1300);
		}
	}
}
