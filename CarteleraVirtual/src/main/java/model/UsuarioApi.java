package model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "usuarioApi")
public class UsuarioApi {

		public UsuarioApi() {
		
		}

		public UsuarioApi(Integer idUsuarioApi, String usuario, String rol) {
		super();
		this.idUsuarioApi = idUsuarioApi;
		this.usuario = usuario;
		this.rol = rol;
		}

		@Id
		@Column(name = "idUsuarioApi")
		private Integer idUsuarioApi;

		
		
		private String usuario;

		private String rol;


		public Integer getIdUsuarioApi() {
			return idUsuarioApi;
		}

		public void setIdUsuarioApi(Integer idUsuarioApi) {
			this.idUsuarioApi = idUsuarioApi;
		}

		public void setUsuario(String usuario) {
			this.usuario = usuario;
		}

		public String getUsuario() {
			return usuario;
		}

		public String getRol() {
			return rol;
		}

		public void setRol(String rol) {
			this.rol = rol;
		}


		
	}


