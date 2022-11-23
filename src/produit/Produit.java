package produit;

public class Produit {
	
	protected static int a=0;
	protected int numProd;
	protected String nomProd;
	protected double P_U;
	
	public int getNumProd() {
		return numProd;
	}
	
	public void setNumProd(int numProd) {
		this.numProd = numProd;
	}
	
	public String getNomProd() {
		return nomProd;
	}
	
	public void setNomProd(String nomProd) {
		this.nomProd = nomProd;
	}
	
	public double getP_U() {
		return P_U;
	}
	
	public void setP_U(double p_U) {
		P_U = p_U;
	}
	
	public Produit(String nomProd) {
		super();
		this.setNumProd(a++);;
		this.setNomProd(nomProd);
	}	
	
	@Override
	public String toString() {
		return this.numProd+" - "+this.nomProd+" - "+this.P_U;
	}
	
}