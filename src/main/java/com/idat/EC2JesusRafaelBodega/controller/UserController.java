package com.idat.EC2JesusRafaelBodega.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.idat.EC2JesusRafaelBodega.dto.UserDTORequest;
import com.idat.EC2JesusRafaelBodega.dto.UserDTOResponse;

import com.idat.EC2JesusRafaelBodega.service.UserService;


@Controller
@RequestMapping( path = "/usuario/v1")
public class UserController {

	@Autowired(required=false)
	private UserService service;
	
	@RequestMapping("/listar")
	public @ResponseBody ResponseEntity<List<UserDTOResponse>>  listar() {
		
		return new ResponseEntity<List<UserDTOResponse>>(service.listarUsers(), HttpStatus.OK) ;
	}
	
	@RequestMapping( path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody UserDTORequest productos) {
		service.guardarUser(productos);
		return  new ResponseEntity<Void>(HttpStatus.CREATED);
		
	}

	@RequestMapping( path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
		UserDTOResponse p =service.obtenerUserId(id);
		if(p != null) {
			service.eliminarUser(id);
			return  new ResponseEntity<Void>(HttpStatus.OK);
		}
		return  new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping( path = "/actualizar", method = RequestMethod.PUT)
	public ResponseEntity<Void> actualizar(@RequestBody UserDTORequest productos) {
		UserDTOResponse p =service.obtenerUserId(productos.getId());
		if(p != null) {
			service.actualizarUser(productos);
			return  new ResponseEntity<Void>(HttpStatus.OK);
		}
		return  new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping( path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserDTOResponse> obtenerId(@PathVariable Integer id) {
		UserDTOResponse p =service.obtenerUserId(id);
		if(p != null) {
			return  new ResponseEntity<UserDTOResponse>(service.obtenerUserId(id),HttpStatus.OK);
		}
		return  new ResponseEntity<UserDTOResponse>(HttpStatus.NOT_FOUND);
	}
}