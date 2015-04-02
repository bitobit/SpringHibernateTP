package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import services.ProduitMetier;
import dao.Produit;

@Controller
public class ProduitController {

	@Autowired         
	ProduitMetier services;    // services est un interface: spring, grace à @Autowired, lui associe une instanciation des l'objet qcmService définit dans spring-beans.xml
	
	// index.aspx
	@RequestMapping(value="/index")
	public String pageIndex(Model model){
		// traitement ..
		model.addAttribute("listeProduits", services.getAllProduits());
		return "produits";
	}
	
	@RequestMapping(value="/searchProduit")
	public String searchProduit(Model model, @RequestParam(value="idProduit") Long id){

		List<Produit> l = new ArrayList<Produit>();
		l.add(services.getProduitById(id));
		
		model.addAttribute("listeProduits", l);
		model.addAttribute("idProduit", id);
		return "produits";
	}
	
	/*
	 * @RequestParam String nom, 
	 * @RequestParam String description, 
	 * @RequestParam Double prix
	 * 
	 */
	@RequestMapping(value="/nouveauProduit")
	public String nouveauProduit(Model model, Produit p){
		//Produit p = new Produit(nom, description, prix);
		services.addProduit(p);
		
		model.addAttribute("listeProduits", services.getAllProduits());
		model.addAttribute("produit", p);
		return "produits";
	}
	
	@RequestMapping(value="/supprimer")
	public String supprimerProduit(Model model, Long id){
		services.deleteProduit(id);
		model.addAttribute("listeProduits", services.getAllProduits());
		return "produits";
	}
}
