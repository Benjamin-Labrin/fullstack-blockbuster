package com.labrin.blockbuster.controller;

import com.labrin.blockbuster.model.Productora;
import com.labrin.blockbuster.service.ProductoraService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/productoras")
public class ProductoraController {

    @Autowired
    private ProductoraService productoraService;

    @GetMapping
    public ResponseEntity<List<Productora>> listarProductoras(){

        System.out.println("[ProductoraController] -> listarProductoras");
        return ResponseEntity.ok(productoraService.getProductoras());
    }

    @PostMapping
    public ResponseEntity<Productora> agregarProductora(@Valid @RequestBody Productora productora){
        System.out.println("[ProdcutoraController] -> agregarProductora");
        return ResponseEntity.status(HttpStatus.CREATED).body(productoraService.saveProductora(productora));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Productora> buscarProductora(@PathVariable int id){
        System.out.println("[ProductoraController] -> buscarProductora id=" + id);
        Productora productora = productoraService.getProductoraId(id);
        if (productora == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productora);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Productora> actualizarProductora(@PathVariable int id, @Valid @RequestBody Productora productora){

        System.out.println("[ProductoraController] -> actualizarProductora id=" + id);
        productora.setId(id);
        Productora actualizada = productoraService.updateProductora(productora);
        if (actualizada == null){

            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProductora(@PathVariable int id){
        System.out.println("[ProductoraController] -> eliminarProductora id=" + id);
        productoraService.deleteProductora(id);
        return ResponseEntity.noContent().build();
    }
    
}
