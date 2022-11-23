package produit;

public class Boisson extends Produit{

	public Boisson(String nomProd) {
		super(nomProd);
		switch(nomProd) {
		case "grenadine 350ml" -> this.setP_U(300);
		case "pamplemousse 350ml" -> this.setP_U(300);
		case "djino 350ml" -> this.setP_U(300);
		case "sprite  350ml" -> this.setP_U(300);
		case "bullet 350ml" -> this.setP_U(850);
		case "pepsi 400ml" -> this.setP_U(400);
		case "sprite 400ml" -> this.setP_U(400);
		case "coca-cola 400ml" -> this.setP_U(400);
		case "buffalo 0.5l" -> this.setP_U(1300);
		case "coca-cola 0.6l" -> this.setP_U(400);
		case "fanta 0.6l" -> this.setP_U(400);
		case "djino 1l" -> this.setP_U(700);
		case "orangina 1l" -> this.setP_U(650);
		case "coca-cola 1l" -> this.setP_U(600);
		case "grenadine 1l" -> this.setP_U(500);
		case "pamplemousse 1l" -> this.setP_U(500);
		}
	}
}