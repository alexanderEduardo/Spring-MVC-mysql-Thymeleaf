package com.springboot.app.repository;

import com.springboot.app.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto,Long> {

    /*@Query("SELECT p FROM Producto p where p.nombre like %?1%"
    +" or p.marca like %?1%" + "or p.madeIn like %?1%")*/
    @Query("SELECT p FROM Producto p where concat(p.id,p.nombre,p.marca,p.madeIn,p.precio)"
            + " like %?1%")
    public List<Producto> finAll(String palabraClave);
}
