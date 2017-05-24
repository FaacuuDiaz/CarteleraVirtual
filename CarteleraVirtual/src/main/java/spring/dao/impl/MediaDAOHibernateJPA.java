package spring.dao.impl;

import model.Media;

import org.springframework.stereotype.Repository;

import interfacesDAO.MediaDAO;

@Repository
public class MediaDAOHibernateJPA extends GenericDAOHibernateJPA<Media> implements MediaDAO {

	public MediaDAOHibernateJPA() {
		super(Media.class);
	}

}
