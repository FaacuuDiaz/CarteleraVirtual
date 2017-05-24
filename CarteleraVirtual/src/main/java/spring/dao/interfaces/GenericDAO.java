package spring.dao.interfaces;

import java.util.List;
import java.io.Serializable;

public interface GenericDAO<T> {
	public List<T> recuperarTodos();

	public void eliminar(T objeto);

	public T eliminar(Serializable objeto);

	public T persistir(T entity);

	public T modificar(T entity);

	public T recuperar(Integer id);

	public boolean existe(Integer id);

	T actualizar(T Objeto);

	T eliminar(int id);
}