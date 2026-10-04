package com.ingridiazrisso.primerapirest.Controllers;


import com.ingridiazrisso.primerapirest.Entities.Producto;
import com.ingridiazrisso.primerapirest.Repositories.ProductoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping
    public List<Producto> getAllProductos(){
        return productoRepository.findAll();
    }

    @GetMapping ("/{id}")
    public Producto getProductById(@PathVariable Long id){
        return productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontro el producto con el ID:" + id));

    }

    @PostMapping
    public  Producto createProduct(@RequestBody Producto producto){
        return productoRepository.save(producto);

    }

    @PutMapping("/{id}")
    public Producto updateProduct(@PathVariable Long id,  @RequestBody Producto p){
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontro el producto con el ID:" + id));
        producto.setNombre(p.getNombre());
        producto.setPrecio(p.getPrecio());

        return productoRepository.save(producto);
    }

    @DeleteMapping("/{id}")
    public String  deletProduct(@PathVariable Long id){
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontro el producto con el ID:" + id));
    productoRepository.delete(producto);
    return "El producto con ID:" + id +"fue eliminado correctamente";
    }


}
