package com.dawii.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawii.dao.ICategoriaProductoDAO;
import com.dawii.dao.IProductoDAO;
import com.dawii.entity.CategoriaProducto;
import com.dawii.entity.Producto;

@Service
public class ProductoService {
	
	@Autowired
	private IProductoDAO repo;
	
	@Autowired
	private ICategoriaProductoDAO repoCate;
	
	// Métodos de categoria
	
	public List<CategoriaProducto> listarCate(){
		return repoCate.findAll();
	}
	
    public CategoriaProducto buscarPorId(Long id) {
        return repoCate.findByIdCategoria(id);
    }
	
	// CRUD
	public Producto grabar(Producto bean) {
		return repo.save(bean);
	}
	public List<Producto> listar(){
		return repo.findAll();
	}
	public Producto buscar(Long id) {
		return repo.findById(id).orElse(null);
	}
	public void eliminar(Long id) {
		repo.deleteById(id);
	}
	
	//CONSULTAS
	public List<Producto> buscarXNombre(String nombre){
		return repo.findByNombreStartingWith(nombre);
	}
	public List<Producto> consulta(String nombre,long idCategoria){
		return repo.consulta(nombre, idCategoria);
	}

	//ACTUALIZAR EL STOCK
	public void actualizarStock(int stock,long id) {
		repo.actualizarStock(stock, id);
	}
	
	public List<Producto> productoXCategoria(Long id){
		return repo.productoXCategoria(id);
	}

}
