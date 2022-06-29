package com.idat.EC2JesusRafaelBodega.service;

import java.util.List;

import com.idat.EC2JesusRafaelBodega.dto.BodegaDTORequest;
import com.idat.EC2JesusRafaelBodega.dto.BodegaDTOResponse;



public interface BodegaService {

	void guardarBodega(BodegaDTORequest producto);
	void actualizarBodega(BodegaDTORequest producto);
	void eliminarBodega(Integer id);
	List<BodegaDTOResponse> listarBodegas();
	BodegaDTOResponse obtenerBodegaId(Integer id);
}
