package spring.dao.interfaces;
import model.*;

public interface UsuarioDAO extends GenericDAO<Usuario> {
	public Usuario chequearAutenticacion(String usuario, String clave);
}