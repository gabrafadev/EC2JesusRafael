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

import com.idat.EC2JesusRafaelBodega.dto.ClienteDTORequest;
import com.idat.EC2JesusRafaelBodega.dto.ClienteDTOResponse;
import com.idat.EC2JesusRafaelBodega.service.ClienteService;

@Controller
@RequestMapping( path = "/cliente/v1")
public class ClienteController {

	@Autowired(required=false)
	private ClienteService service;
	
	@RequestMapping("/listar")
	public @ResponseBody ResponseEntity<List<ClienteDTOResponse>>  listar() {
		
		return new ResponseEntity<List<ClienteDTOResponse>>(service.listarClientes(), HttpStatus.OK) ;
	}
	
	@RequestMapping( path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody ClienteDTORequest productos) {
		service.guardarCliente(productos);
		return  new ResponseEntity<Void>(HttpStatus.CREATED);
		
	}

	@RequestMapping( path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
		ClienteDTOResponse p =service.obtenerClienteId(id);
		if(p != null) {
			service.eliminarCliente(id);
			return  new ResponseEntity<Void>(HttpStatus.OK);
		}
		return  new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping( path = "/actualizar", method = RequestMethod.PUT)
	public ResponseEntity<Void> actualizar(@RequestBody ClienteDTORequest productos) {
		ClienteDTOResponse p =service.obtenerClienteId(productos.getId());
		if(p != null) {
			service.actualizarCliente(productos);
			return  new ResponseEntity<Void>(HttpStatus.OK);
		}
		return  new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping( path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<ClienteDTOResponse> obtenerId(@PathVariable Integer id) {
		ClienteDTOResponse p =service.obtenerClienteId(id);
		if(p != null) {
			return  new ResponseEntity<ClienteDTOResponse>(service.obtenerClienteId(id),HttpStatus.OK);
		}
		return  new ResponseEntity<ClienteDTOResponse>(HttpStatus.NOT_FOUND);
	}
}