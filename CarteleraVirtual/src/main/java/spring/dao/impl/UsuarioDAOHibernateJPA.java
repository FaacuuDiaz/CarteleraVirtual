package spring.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.dao.interfaces.CarteleraDAO;
import spring.dao.interfaces.UsuarioApiDAO;
import spring.dao.interfaces.UsuarioDAO;
import model.Cartelera;
import model.Usuario;
import model.UsuarioApi;

@Repository
public class UsuarioDAOHibernateJPA extends GenericDAOHibernateJPA<Usuario> implements UsuarioDAO {
	
	@Autowired
	UsuarioApiDAO userApiDAO;
	
	public UsuarioDAOHibernateJPA() {
		super(Usuario.class);
	}

	public Usuario chequearAutenticacion(String unUsuario, String unaClave) {
		EntityManager em = EMF.getEMF().createEntityManager();
		Query q = em.createQuery("SELECT p FROM Usuario p WHERE p.usuario = :usr AND p.clave = :clave");
		q.setParameter("usr", unUsuario);
		q.setParameter("clave", unaClave);
		List<Usuario> resultado = (List<Usuario>) q.getResultList();
		if (resultado.size() != 0) {
			Integer id = resultado.get(0).getId();
			return (this.recuperar(id)); // recupera el usuario y lo retorna
		} else {
			return null;
		}

	}

	
	@Override
	public Usuario recuperar(Integer id){
		Usuario user = getEntityManager().find(Usuario.class, id);
		return user;
	}
	
	@Override
	public boolean existe(Integer id){
		Usuario user = getEntityManager().find(Usuario.class, id);
		if(user == null){
			return false;
		}
		else{
			return true;
		}
		
	}
}