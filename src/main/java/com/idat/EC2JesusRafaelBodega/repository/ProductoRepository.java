package com.idat.EC2JesusRafaelBodega.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.EC2JesusRafaelBodega.model.Productos;



@Repository
public interface ProductoRepository extends JpaRepository<Productos,Integer>{
	


}
