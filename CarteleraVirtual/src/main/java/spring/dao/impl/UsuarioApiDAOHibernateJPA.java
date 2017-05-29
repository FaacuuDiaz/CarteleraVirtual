package spring.dao.impl;

import org.springframework.stereotype.Repository;

import model.UsuarioApi;
import spring.dao.interfaces.UsuarioApiDAO;

@Repository
public class UsuarioApiDAOHibernateJPA extends GenericDAOHibernateJPA<UsuarioApi> implements UsuarioApiDAO {
	@Override
	public UsuarioApi recuperar(Integer id){
		UsuarioApi user = getEntityManager().find(UsuarioApi.class, id);
		return user;
	}
	
	@Override
	public boolean existe(Integer id){
		UsuarioApi user = getEntityManager().find(UsuarioApi.class, id);
		if(user == null){
			return false;
		}
		else{
			return true;
		}
		
	}
}
