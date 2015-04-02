package services;

import java.util.List;


import dao.Produit;
import dao.ProduitDAO;

public class ProduitMetierImplementation implements ProduitMetier {
	
	ProduitDAO dao ;

	@Override
	public void addProduit(Produit p) {
		dao.addProduit(p);
	}

	@Override
	public void deleteProduit(Long id) {
		dao.deleteProduit(id);
	}

	@Override
	public Produit getProduitById(Long id) {
		return dao.getProduitById(id);
	}

	@Override
	public List<Produit> getAllProduits() {
		return dao.getAllProduits();
	}

	@Override
	public void updateProduit(Produit p) {
		dao.updateProduit(p);
	}
	
	public void setDao(ProduitDAO dao) {
		this.dao = dao;
	}
}
