package com.labrin.blockbuster.service;

import com.labrin.blockbuster.model.Pelicula;
import com.labrin.blockbuster.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculaService {

    @Autowired
    private PeliculaRepository peliculaRepository;

    public List<Pelicula> getPeliculas(){
        return peliculaRepository.findAll();
        
    }
    
    public Pelicula savePelicula(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }


    public Pelicula getPeliculaId(int id) {
        return peliculaRepository.findById(id).orElse(null);      
    }

    public Pelicula updatePelicula(Pelicula pelicula) {
        if (peliculaRepository.existsById(pelicula.getId())){
            return null;
        }
        return peliculaRepository.save(pelicula);
    }

    public void deletePelicula(int id){
        peliculaRepository.deleteById(id);

    }
}
