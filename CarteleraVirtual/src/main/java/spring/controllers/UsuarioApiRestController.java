package spring.controllers;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import model.UsuarioApi;
import spring.dao.interfaces.UsuarioApiDAO;


@RestController

public class UsuarioApiRestController {
	
	@Autowired
	UsuarioApiDAO userApiDAO;
	
	@RequestMapping(value = "/rol", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UsuarioApi> rol(@RequestBody UsuarioApi login) {
		
		UsuarioApi user = userApiDAO.recuperar(login.getIdUsuarioApi());
		
		if (user == null) {
			
			return new ResponseEntity<UsuarioApi>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<UsuarioApi>(user, HttpStatus.OK);
	}
	
}
