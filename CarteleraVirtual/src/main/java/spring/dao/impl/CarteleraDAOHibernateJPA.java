package spring.dao.impl;

import org.springframework.stereotype.Repository;

import spring.dao.interfaces.CarteleraDAO;
import model.Cartelera;

@Repository
public class CarteleraDAOHibernateJPA extends GenericDAOHibernateJPA<Cartelera> implements CarteleraDAO {

	public CarteleraDAOHibernateJPA() {
		super(Cartelera.class);
	}

}
