package gestionnaire_magasin;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import achat.Achat;
import produit.Produit;
import rayon.Rayon;

public class Magasin {
	private String name;
	private ArrayList<Rayon> listRayon;
	private ArrayList<Achat> historique;
	Scanner sc = new Scanner(System.in);
	int rep;
	String str ;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public ArrayList<Rayon> getListRayon() {
		return listRayon;
	}
	
	public void setListRayon(ArrayList<Rayon> listRayon) {
		this.listRayon = listRayon;
	}
	
	public Magasin(String name, Rayon...rayon) {
		super();
		this.setName(name);
		this.listRayon = new ArrayList<Rayon>();
		this.historique = new ArrayList<Achat>();
		for(Rayon r : rayon) {
			if(r != null) this.listRayon.add(r);
		}
	}
	
	public void start() {
		System.out.println("|------------------------------------------------------- BIENVENUE -------------------------------------------------------|");
		this.menu0();
	}
	
	public void menu0() {
		System.out.println("|                                                                                                                         |");
		System.out.println("|__________________________________     Quelle opération voulez vous effectuer ?    ______________________________________|");
		System.out.println("|                                                                                                                         |");
		System.out.println("| (1) : facturation    (2) : lister le stock    (3) : rechercher un produit     (4) : historique de vente    (0) : exit   | ");
		rep = sc.nextInt();
		while(rep != 1 && rep != 2 && rep != 3 && rep !=4 && rep != 0) {
			System.out.println("Entrée invalide, ....veuillez selectionner une des opérations proposées......");
			this.menu0();
			rep = sc.nextInt();
		}
		this.menu1();
	}
	
	public void menu1() {
		switch (rep){
		case 1 -> {
			this.facturation();
		}
		case 2 -> this.menu12();
		case 3 -> {
			System.out.println("Nom du produit recherché : ");
			boolean b = false;
			str =  sc.nextLine();
			str = sc.nextLine();
			for(Rayon r : listRayon) {
				if(r.rechercherProd(str)) {
					b = true;
				}
			}
			if(b==false) System.out.println("Produit inexistant \n");
			System.out.println("Entrez n'importe quel chiffre pour continuer......");
			rep =sc.nextInt();
			this.menu0();
		}
		case 4 ->{
			this.historisationAchat();
			System.out.println("Entrez n'importe quel chiffre pour continuer......");
			rep =sc.nextInt();
			this.menu0();
		}
		case 0 ->{
			System.out.println("Etes vous sur de vouloir sortir.....? (o) : oui or (sometihng) : non");
			String rs = sc.nextLine();
			rs = sc.nextLine();
			if(rs.equalsIgnoreCase("o")) System.out.println("Au revoir...");
			else menu0();
		}
		}
	}
	
	public void menu12() {
		System.out.println("|                                                                                                                         |");
		System.out.println("|          (1) : lister tous les produits    (2) : lister les produits d'un rayon    (3) : retour     (0) : exit          |");
		rep = sc.nextInt();
		while(rep != 1 && rep != 2 && rep != 3 && rep !=0) {
			System.out.println("Entrée invalide, ....veuillez selectionner une des opérations suivantes : ");
			this.menu12();
		}
		this.menuR12();
	}
	
	public void menuR12() {
		switch(rep) {
		case 1 -> {
			this.seeAllProducts();
			System.out.println("Entrez n'importe quel chiffre pour continuer....");
			rep =sc.nextInt();
			this.menu0();
		}
		case 2 -> this.menuR122();
		case 3 -> this.menu0();
		}
	}
	
	public void menuR122() {
		this.seeAllCategories();
		rep = sc.nextInt();
		while((rep-1) >=listRayon.size()) {
			System.out.println("Entrée invalide, ....veuillez selectionner une des valeurs suivantes : ");
			this.menuR122();
		}
		listRayon.get(rep-1).seeProducts();
		System.out.println("Entrez n'importe quel chiffre pour continuer....");
		rep =sc.nextInt();
		this.menu0();
	}
	
	public void seeAllProducts() {
		for(Rayon r : listRayon) {
			r.seeProducts();
		}
	}
	
	public void seeAllCategories() {
		System.out.println("Liste des rayons");
		for(Rayon r : listRayon) {
			System.out.println("("+(listRayon.indexOf(r)+1)+" )------ : "+r.getCategorie().charAt(0)+r.getNumRayon()  );
		}
	}
	
	public ArrayList<Produit> enregistrementProd(){
		ArrayList<Produit> l = new ArrayList<Produit>();
		int i = 1;
		int numProd;
		System.out.println("entrez les id des produits... (-1) pour mettre fin à l'enregistrement.  ");
		do {
			System.out.print(i+". ");
			numProd = sc.nextInt();
			for(Rayon r : listRayon) {
				if(r.rechercherProd(numProd) != null) {
					l.add(r.rechercherProd(numProd));
					r.retirerProd(numProd);
					i++;
				}
			}
		}while(numProd != -1);
		System.out.println("enregistrement reussi");
		return l;
	}
	
	public void facturation() {
		Achat achat = new Achat(this.enregistrementProd());
		historique.add(achat);
		try {
			FileWriter file = new FileWriter(System.getProperty("user.home")+System.getProperty("file.separator")+"facture"+achat.getNumCmde()+".txt");
			System.out.println();
			file.write("---------------------------- "+this.name+" ----------------------------"+"\n---Numero achat : "+achat.getNumCmde()+"\n"+"---Date : "+achat.getDte()+"\n---Client : "+achat.getNomCli()+"\n\n"+achat.afficherAchat()+"\nTotal : "+achat.getTotal()+"Fcfa");
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Entrez n'importe quel chiffre pour continuer......");
		rep =sc.nextInt();
		this.menu0();
	}
	
	public void historisationAchat() {
		int compt = 0;
		for(Achat achat : this.historique) {
			if(achat != null) {
				achat.afficherAchat();
				System.out.println();
				compt ++;
			}
		}
		if(compt == 0) System.out.println("Aucun produit n'a été vendu.....");
	}
}