package com.labrin.blockbuster.controller;


import com.labrin.blockbuster.model.Pelicula;
import com.labrin.blockbuster.service.PeliculaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/peliculas")

public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;


    @GetMapping
    public ResponseEntity<List<Pelicula>> listarPeliculas(){

        return ResponseEntity.ok(peliculaService.getPeliculas());
    }
    
    @PostMapping
    public ResponseEntity<Pelicula> agregarPelicula(@Valid @RequestBody Pelicula pelicula){

        return ResponseEntity.status(HttpStatus.CREATED).body(peliculaService.savePelicula(pelicula));     
    }


    @GetMapping("/{id}")
    public ResponseEntity<Pelicula> buscarPelicula(@PathVariable int id){

        Pelicula pelicula = peliculaService.getPeliculaId(id);
        if (pelicula == null) {

            return ResponseEntity.notFound().build();

        }
        return ResponseEntity.ok(pelicula);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Pelicula> actualizarPelicula(@PathVariable int id, @Valid @RequestBody Pelicula pelicula) {
        pelicula.setId(id);
        Pelicula actualizada = peliculaService.updatePelicula(pelicula);
        if(actualizada == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizada);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPelicula(@PathVariable int id) {
        peliculaService.deletePelicula(id);
        return ResponseEntity.noContent().build();

    }
}
