package com.ingridiazrisso.primerapirest.Repositories;

import com.ingridiazrisso.primerapirest.Entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository <Producto, Long> {

}
