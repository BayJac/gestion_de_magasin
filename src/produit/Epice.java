package produit;

public class Epice extends Produit {

	public Epice(String nomProd) {
		super(nomProd);
		switch(nomProd) {
		case "ducros herbe de provinces 120g" -> this.setP_U(1400);
		case "ducros assaisonnement provençal 35g" -> this.setP_U(400);
		case "schwartz mix d'herbes 11g" -> this.setP_U(850);
		case "ducros mélange espanol 52g" -> this.setP_U(14000);
		case "schwartz mélange chili 29g" -> this.setP_U(0);
		case "ducros paprika doux en poudre 40g" -> this.setP_U(0);
		case "ducros curry tandoori 37g" -> this.setP_U(0);
		case "ducros poudre de curry 25g" -> this.setP_U(0);
		case "mccormick poudre de chili" -> this.setP_U(0);
		/*case "" -> this.setP_U(0);
		case "" -> this.setP_U(0);
		case "" -> this.setP_U(0);
		case "" -> this.setP_U(0);
		case "" -> this.setP_U(0);
		case "" -> this.setP_U(0);
		case "" -> this.setP_U(0);
		case "" -> this.setP_U(0);
		case "" -> this.setP_U(0);
		case "" -> this.setP_U(0);
		case "" -> this.setP_U(0);
		case "" -> this.setP_U(0);
		case "" -> this.setP_U(0);
		case "" -> this.setP_U(0);
		case "" -> this.setP_U(0);
		case "" -> this.setP_U(0);
		case "" -> this.setP_U(0);
		case "" -> this.setP_U(0);
		case "" -> this.setP_U(0);
		case "" -> this.setP_U(0);
		case "" -> this.setP_U(0);
		case "" -> this.setP_U(0);
		case "" -> this.setP_U(0);
		case "" -> this.setP_U(0);
		case "" -> this.setP_U(0);
		case "" -> this.setP_U(0);
		case "" -> this.setP_U(0);*/
		}
	}
}
