package com.idat.EC2JesusRafaelBodega.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.idat.EC2JesusRafaelBodega.dto.ProductoDTORequest;
import com.idat.EC2JesusRafaelBodega.dto.ProductoDTOResponse;
import com.idat.EC2JesusRafaelBodega.model.Productos;
import com.idat.EC2JesusRafaelBodega.repository.ProductoRepository;


public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoRepository repository;

	@Override
	public void guardarProducto(ProductoDTORequest producto) {
		
		Productos p = new Productos();
		p.setProducto(producto.getNombre());
		p.setDescripcion(p.getDescripcion());
		p.setPrecio(producto.getPrecioProducto());
		p.setStock(producto.getStockProducto());
		repository.save(p);
	}

	@Override
	public void actualizarProducto(ProductoDTORequest producto) {
		// TODO Auto-generated method stub
		
		Productos p = new Productos();
		p.setIdProducto(producto.getId());
		p.setProducto(producto.getNombre());
		p.setDescripcion(p.getDescripcion());
		p.setPrecio(producto.getPrecioProducto());
		p.setStock(producto.getStockProducto());

		repository.saveAndFlush(p);
	}

	@Override
	public void eliminarProducto(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public List<ProductoDTOResponse> listarProductos() {
		
		List<ProductoDTOResponse> listar = new ArrayList<>();
		
		ProductoDTOResponse dto = null;
		
		List<Productos> p = repository.findAll();
		
		for (Productos productos : p) {
			
			dto = new ProductoDTOResponse();
			
			dto.setDescripcionProducto(productos.getDescripcion());
			dto.setNombre(productos.getProducto());
			dto.setPrecioProducto(productos.getPrecio());
			dto.setStockProducto(productos.getStock());
			dto.setId(productos.getIdProducto());
			
			listar.add(dto);
		}
		
		return listar;
	}
			
		
	@Override
	public ProductoDTOResponse obtenerProductoId(Integer id) {
		// TODO Auto-generated method stub
		
		Productos productos = repository.findById(id).orElse(null);
		ProductoDTOResponse dto = new ProductoDTOResponse();
		
		dto.setDescripcionProducto(productos.getDescripcion());
		dto.setNombre(productos.getProducto());
		dto.setPrecioProducto(productos.getPrecio());
		dto.setStockProducto(productos.getStock());
		dto.setId(productos.getIdProducto());
		
		return dto;
	}

}
