package implementacionesDAO;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import interfacesDAO.GenericDAO;


@Transactional
@Repository
public class GenericDAOHibernateJPA<T> implements GenericDAO<T> {
	protected Class<T> persistentClass;
	private EntityManagerFactory em = Persistence.createEntityManagerFactory("unidad");
	

	@PersistenceContext
	private EntityManager entityManager = this.em.createEntityManager();

	public GenericDAOHibernateJPA(Class<T> class1) {
		persistentClass = class1;
	}
	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.entityManager = em;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public T persistir(T entity) {
		this.entityManager.persist(entity);
		return entity;
	}

	public void agregar(Object cartelera){
		this.entityManager = this.em.createEntityManager();
		EntityTransaction etx = entityManager.getTransaction();
		etx.begin();
		entityManager.persist(cartelera);
		etx.commit();
		entityManager.close();
	}
	
	public void eliminar(T entity) {
		entityManager = em.createEntityManager();
		EntityTransaction etx = entityManager.getTransaction();
		etx.begin();
		entityManager.remove(entityManager.merge(entity));
		etx.commit();
		entityManager.close();		
	}
	
	public boolean existe(Integer id) {
		Query consulta = this.getEntityManager()
				.createQuery("select e from " + getPersistentClass().getSimpleName() + " e where e.id=id");
		List<T> resultado = (List<T>) consulta.getResultList();
		if (resultado.size() != 0) {
			return true;
		} else {
			return false;
		}
	}

	public T modificar(T entity) {
		this.getEntityManager().merge(entity);
		return entity;
	}

	/*public T eliminar(T entity) {
		this.getEntityManager().merge(entity);
		this.getEntityManager().remove(entity);
		return entity;
	}*/

	public List<T> recuperarTodos() {
		Query consulta = this.entityManager.createQuery("from " + getPersistentClass().getSimpleName());
		List<T> resultado = (List<T>) consulta.getResultList();
		if (resultado.size() != 0) {
			return resultado;
		} else {
			return null;
		}
	}

	private Class<T> getPersistentClass() {
		return this.persistentClass;
	}

	public T recuperar(Integer id) {
		/*Query consulta = this.getEntityManager()
				.createQuery("select e from " + getPersistentClass().getSimpleName() + " e where e.id=id");
		List<T> resultado = (List<T>) consulta.getResultList();
		if (resultado.size() != 0) {
			return resultado.get(0);
		} else {*/
			return null;
		//}
	}

	public T eliminar(Serializable id) {
		T entity = this.getEntityManager().find(this.getPersistentClass(), id);
		if (entity != null) {
			this.eliminar(entity);
		}
		return entity;
	}
	@Override
	public T eliminar(int id) {
		T entity = (T) em.createEntityManager().find(this.getPersistentClass(), id);
		if (entity != null) {
			this.eliminar(entity);
		}
		return entity;
	}
	@Override
	public T actualizar(T objetoPersistible) {
		entityManager = em.createEntityManager();
		EntityTransaction etx = entityManager.getTransaction();
		etx.begin();
		entityManager.merge(objetoPersistible);
		etx.commit();
		entityManager.close();
		return objetoPersistible;
	}
}

/*
 * public T persistir(T entity) { EntityManager em =
 * EMF.getEMF().createEntityManager(); EntityTransaction tx = null; try { tx =
 * em.getTransaction(); tx.begin(); em.persist(entity); tx.commit(); } catch
 * (RuntimeException e) { if (tx != null && tx.isActive()) tx.rollback(); throw
 * e; // escribir en un log o mostrar un mensaje } finally { em.close(); }
 * return entity; }
 * 
 * public T modificar(T entity) { EntityManager em =
 * EMF.getEMF().createEntityManager(); EntityTransaction etx =
 * em.getTransaction(); etx.begin(); T entity2 = em.merge(entity); etx.commit();
 * em.close(); return entity2; }
 * 
 * public T eliminar(Serializable id) { T entity =
 * EMF.getEMF().createEntityManager().find(this.getPersistentClass(), id); if
 * (entity != null) { this.eliminar(entity); } return entity; }
 * 
 * public List<T> recuperarTodos() { Query consulta =
 * EMF.getEMF().createEntityManager() .createQuery("select e from " +
 * getPersistentClass().getSimpleName()); List<T> resultado = (List<T>)
 * consulta.getResultList(); if (resultado.size() != 0) { return resultado; }
 * else { return null; } }
 * 
 * public T eliminar(T objeto) { EntityManager em =
 * EMF.getEMF().createEntityManager(); EntityTransaction tx = null; try { tx =
 * em.getTransaction(); tx.begin(); objeto = em.merge(objeto);
 * em.remove(objeto); tx.commit(); } catch (RuntimeException e) { if (tx != null
 * && tx.isActive()) tx.rollback(); throw e; // escribir en un log o mostrar un
 * mensaje } finally { em.close(); } return objeto; }
 * 
 * public T recuperar(Integer id) { Query consulta =
 * EMF.getEMF().createEntityManager() .createQuery("select e from " +
 * getPersistentClass().getSimpleName() + " e where e.id=id"); List<T> resultado
 * = (List<T>) consulta.getResultList(); if (resultado.size() != 0) { return
 * resultado.get(0); } else { return null; } }
 * 
 * public Class<T> getPersistentClass() { return persistentClass; }
 * 
 * public void setPersistentClass(Class<T> persistentClass) {
 * this.persistentClass = persistentClass; }
 */
