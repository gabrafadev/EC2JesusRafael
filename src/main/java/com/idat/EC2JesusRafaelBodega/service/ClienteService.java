package com.idat.EC2JesusRafaelBodega.service;

import java.util.List;

import com.idat.EC2JesusRafaelBodega.dto.ClienteDTORequest;
import com.idat.EC2JesusRafaelBodega.dto.ClienteDTOResponse;




public interface ClienteService {
	
	
	void guardarCliente(ClienteDTORequest producto);
	void actualizarCliente(ClienteDTORequest producto);
	void eliminarCliente(Integer id);
	List<ClienteDTOResponse> listarClientes();
	ClienteDTOResponse obtenerClienteId(Integer id);

}
