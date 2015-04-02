package dao;

import java.util.List;


import org.hibernate.Session;

import util.HibernateUtil;

public class ProduitImplBD implements ProduitDAO {

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addProduit(Produit p) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(p);
		session.getTransaction().commit();
	}

	@Override
	public void deleteProduit(Long id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();	
		Produit p = (Produit) session.load(Produit.class, id);
		session.delete(p);
		session.getTransaction().commit();
	}

	@Override
	public Produit getProduitById(Long id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();	
		Produit p = (Produit) session.load(Produit.class, id);
		return p;
	}

	@Override
	public List<Produit> getAllProduits() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();	
		return session.createQuery("from Produit").list();
	}

	@Override
	public void updateProduit(Produit p) {
		// TODO Auto-generated method stub

	}

}
