package com.springboot.app.service;

import com.springboot.app.models.Producto;
import com.springboot.app.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    ProductoRepository repository;

    public List<Producto> listAll(String palabraClave){
    if (palabraClave!=null){
        return repository.finAll(palabraClave);
    }
        return repository.findAll();
    }

    public void save(Producto producto){
        repository.save(producto);
    }
    public Producto get(Long id){
        return repository.findById(id).orElse(null);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}

