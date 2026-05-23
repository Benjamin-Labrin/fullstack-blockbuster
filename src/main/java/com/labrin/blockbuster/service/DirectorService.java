package com.labrin.blockbuster.service;

import com.labrin.blockbuster.model.Director;
import com.labrin.blockbuster.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DirectorService {

    @Autowired
    private DirectorRepository directorRepository;

    public List<Director> getDirectores(){
        return directorRepository.findAll();

    }

    public Director saveDirector(Director director) {
        return directorRepository.save(director);
    }

    public Director getDirectorId(int id){
        return directorRepository.findById(id).orElse(null);
    }

    public Director updateDirector(Director director) {

        if (!directorRepository.existsById(director.getId())){
            return null;
        }
        return directorRepository.save(director);
    }

    public void deleteDirector(int id){
        directorRepository.deleteById(id);
    }

    
}
