package rayon;

import java.util.ArrayList;

import produit.Boisson;
import produit.Epice;
import produit.Produit;

public class Rayon {
	
	//declaration des variables
	private static int a = 0;
	private int numRayon;
	private String categorie;
	private ArrayList<Produit> listProd;
	
	public int getNumRayon() {
		return numRayon;
	}

	public void setNumRayon(int numRayon) {
		this.numRayon = numRayon;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public ArrayList<Produit> getListProd() {
		return listProd;
	}

	public void setListProd(ArrayList<Produit>listProd) {
		this.listProd = listProd;
	}
	
	public Rayon(Produit...produit) {
		super();
		this.numRayon = a++;
		this.listProd = new ArrayList<Produit>();
		for(Produit p : produit) {
			if(p != null) {
				this.listProd.add(p);
			}
		}
	}
	
	//constructeur permettant le remplissage du rayon en entrant uniquement le nom des produits dont les prix sont mentionnés dans leur construteur
	public Rayon(String categorie,String...produit) {
		super();
		this.numRayon = a++;
		this.categorie = categorie;
		this.listProd = new ArrayList<Produit>();
		//remplissage du rayon selon sa categorie
		for(String str : produit) {
			if(str != null) {
				switch(categorie) {
				case "boisson" ->this.listProd.add(new Boisson(str));
				case "epice" ->this.listProd.add(new Epice(str));
				}
			}
		}
	}

	void retirerProd( String nomProd ) {
		Produit p = null;
		for(Produit x : listProd ) {
			if(x.getNomProd().equals(nomProd)) {
				p = x;
				break;
			}
		}
		if(p != null) {
			listProd.remove(p);
			System.out.println("Produit retiré du rayon avec succès");
		}
		else {
			System.out.println("Ce produit n'existe plus dans le rayon");
		}
	}
	
	public void retirerProd(int numProd) {
		Produit p = null;
		for(Produit x : listProd ) {
			if(x.getNumProd() == numProd) {
				p = x;
				break;
			}
		}
		if(p != null) {
			listProd.remove(p);
			System.out.println("checked !");
		}
		else {
			System.out.println("Ce produit n'existe pas dans le(s) rayon(s)");
		}
	}
	
	public Produit rechercherProd(int numProd) {
		Produit q = null;
		for(Produit p : listProd) {
			if(p.getNumProd() == numProd) {
				q= p;
				break;
			}
		}
		return q;
	}
	
	public boolean rechercherProd(String nomProd) {
		int compt =0;	
		Produit p=null;
		for(Produit x : listProd) {
			if(x.getNomProd().equals(nomProd)) {
				p=x;
				compt++;
			}
		}
		if(compt>0) {
			System.out.println("rayon : "+this.categorie.charAt(0)+""+this.numRayon+" "+nomProd+" - Prix Unitaire : "+ p.getP_U() +" Fcfa - Quantité : "+compt+"\n");
			return true;
			//return "rayon : "+this.categorie.charAt(0)+""+this.numRayon+" "+nomProd+" - Prix Unitaire : "+ p.getP_U() +" Fcfa - Quantité : "+compt+"\n";
		}
		else {
			return false;
		}
	}

	public void seeProducts() {
		ArrayList<String> l = new ArrayList<String>();
		for(Produit x : listProd) {
			if(l.contains(x.getNomProd())){
			}
			else{
				l.add(x.getNomProd());
				rechercherProd(x.getNomProd());
			}
		}
		if(l.isEmpty()) System.out.println("Rayon vide");
	}
}