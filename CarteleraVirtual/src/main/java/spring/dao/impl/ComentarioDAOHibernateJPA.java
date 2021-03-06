package spring.dao.impl;

import org.springframework.stereotype.Repository;

import spring.dao.interfaces.ComentarioDAO;
import model.Comentario;

@Repository
public class ComentarioDAOHibernateJPA extends GenericDAOHibernateJPA<Comentario> implements ComentarioDAO {

	public ComentarioDAOHibernateJPA() {
		super(Comentario.class);
	}

}
