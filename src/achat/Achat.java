package achat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import produit.Produit;

public class Achat {

	Scanner sc = new Scanner(System.in);
	private static int a = 0;
	private int numCmde;
	private List<Produit> listProd;
	private double total;
	private String nomCli;
	private Date dte;
	
	public int getNumCmde() {
		return numCmde;
	}
	
	public void setNumCmde(int numCmde) {
		this.numCmde = numCmde;
	}
	
	public List<Produit> getListProd() {
		return listProd;
	}
	
	public void setListProd(List<Produit> listProd) {
		this.listProd = listProd;
	}
	
	public double getTotal() {
		return total;
	}
	
	public void setTotal(double total) {
		this.total = total;
	}
	
	public String getNomCli() {
		return nomCli;
	}
	
	public void setNomCli(String nomCli) {
		this.nomCli = nomCli;
	}
	
	public Date getDte() {
		return dte;
	}
	
	public void setDte(Date dte) {
		this.dte = dte;
	}
	
	public Achat(ArrayList<Produit> listProd) {
		super();
		this.setNumCmde(a++);
		this.listProd = listProd;
		System.out.println("\n entrez le nom du client :  ");
		this.nomCli = sc.nextLine();
		this.dte = new Date();
		this.Total();
	}
	
	public double Total() {
		for(Produit p : this.listProd) {
			this.setTotal(total + p.getP_U());
		}
		if(this.total >= 50000) this.setTotal(total - (5*total)/100);
		return this.getTotal();
	}
	
	public String afficherAchat() {
		ArrayList<String> l = new ArrayList<String>();
		System.out.println("Numero achat : "+numCmde);
		System.out.println("Date : "+dte);
		System.out.println("Client : "+nomCli+"\n");
		String str="";
		for(Produit p : listProd) {
			if(p != null) {
					if(l.contains(p.getNomProd())){
					}
					else{
						l.add(p.getNomProd());
						str = str +rechercherProd(p.getNomProd())+"\n";
					}
				}
				if(l.isEmpty()) System.out.println("Aucun produit acheté");
		}
		System.out.println(str);
		System.out.println(" Total : "+ this.getTotal());
		return str;
	}

	String rechercherProd(String nomProd) {
		int compt =0;	
		Produit p=null;
		for(Produit x : listProd) {
			if(x.getNomProd().equals(nomProd)) {
				p=x;
				compt++;
			}
		}
		if(compt>0) {
			//System.out.println(nomProd+" - Prix Unitaire : "+ p.getP_U() +" Fcfa - Quantité : "+compt+"---------"+(compt * p.getP_U())+"\n");
			return nomProd+" - Prix Unitaire : "+ p.getP_U() +" Fcfa - Quantité : "+compt+"---------"+(compt * p.getP_U()+"\n");
		}
		else {
			return null;
		}
	}
}
