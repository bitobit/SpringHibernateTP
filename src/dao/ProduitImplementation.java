package dao;

import java.util.ArrayList;
import java.util.List;

public class ProduitImplementation implements ProduitDAO {
	
	List<Produit> produits = new ArrayList<Produit>();
	Long idInc = 0L;
	
	@Override
	public void init(){
		System.out.println("Init ProduitImplementation");
		addProduit(new Produit("PC1","HP1",7000D));
		addProduit(new Produit("PC2","HP2",6000D));
		addProduit(new Produit("PC3","HP3",8000D));
		addProduit(new Produit("PC4","HP4",5000D));
		addProduit(new Produit("PC5","HP5",9000D));
		addProduit(new Produit("PC6","HP6",4000D));
	}
	public void addProduit(Produit p) {
		// TODO Auto-generated method stub
		p.setIdProduit(++idInc);
		produits.add(p);
	}

	@Override
	public void deleteProduit(Long id) {
		// TODO Auto-generated method stub
		produits.remove(getProduitById(id));
		/*
		for(Produit p : produits){
			if(p.getIdProduit() .equals(id) ){
				produits.remove(p);
				break;
			}
		}
		*/
	}

	@Override
	public Produit getProduitById(Long id) {
		// TODO Auto-generated method stub
		Produit produit = new Produit();
		for(Produit p : produits){
			if(p.getIdProduit() .equals(id) ){
				produit = p;
				break;
			}
		}
		return produit;
	}

	@Override
	public List<Produit> getAllProduits() {
		// TODO Auto-generated method stub
		return produits;
	}

	@Override
	public void updateProduit(Produit produit) {
		// TODO Auto-generated method stub
		for(Produit p : produits){
			if(p.getIdProduit().equals(produit.getIdProduit()) ){
				p.setDescription(produit.getDescription());
				p.setNom(produit.getNom());
				p.setPrix(produit.getPrix());
				break;
			}
		}
	}

}
