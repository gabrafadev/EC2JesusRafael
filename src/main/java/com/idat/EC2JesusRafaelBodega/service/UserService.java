package com.idat.EC2JesusRafaelBodega.service;

import java.util.List;

import com.idat.EC2JesusRafaelBodega.dto.UserDTORequest;
import com.idat.EC2JesusRafaelBodega.dto.UserDTOResponse;



public interface UserService {

	void guardarUser(UserDTORequest producto);
	void actualizarUser(UserDTORequest producto);
	void eliminarUser(Integer id);
	List<UserDTOResponse> listarUsers();
	UserDTOResponse obtenerUserId(Integer id);
}
