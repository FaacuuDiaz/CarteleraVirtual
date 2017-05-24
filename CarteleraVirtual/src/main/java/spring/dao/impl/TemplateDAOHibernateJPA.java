package spring.dao.impl;

import org.springframework.stereotype.Repository;

import spring.dao.interfaces.TemplateDAO;
import model.Template;

@Repository
public class TemplateDAOHibernateJPA extends GenericDAOHibernateJPA<Template> implements TemplateDAO {

	public TemplateDAOHibernateJPA() {
		super(Template.class);
	}

}
