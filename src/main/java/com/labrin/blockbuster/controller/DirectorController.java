package com.labrin.blockbuster.controller;

import com.labrin.blockbuster.model.Director;
import com.labrin.blockbuster.service.DirectorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/directores")
public class DirectorController {
    
    @Autowired
    private DirectorService directorService;

    @GetMapping
    public ResponseEntity<List<Director>> listarDirectores(){

        System.out.println("[DirectorController] -> listarDirectores");
        return ResponseEntity.ok(directorService.getDirectores());
    }

    @PostMapping
    public ResponseEntity<Director> agregarDirector(@Valid @RequestBody Director director){
        System.out.println("[DirectorController] -> agregarDirector");
        return ResponseEntity.status(HttpStatus.CREATED).body(directorService.saveDirector(director));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Director> buscarDirector(@PathVariable int id) {
        System.out.println("[DirectorController] -> buscarDirector id=" + id);
        Director director = directorService.getDirectorId(id);
        if (director == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(director);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Director> acutalizarDirector(@PathVariable int id, @Valid @RequestBody Director director){

        System.out.println("[DirectorController] -> actualizarDirector id=" + id);
        director.setId(id);
        Director actualizado = directorService.updateDirector(director);
        if (actualizado == null){

            return ResponseEntity.notFound().build();

        }
        return ResponseEntity.ok(actualizado);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDirector(@PathVariable int id){
        System.out.println("[DirectorController] -> eliminarDirector id=" + id);
        directorService.deleteDirector(id);
        return ResponseEntity.noContent().build();
    }
 
}
