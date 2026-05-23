package com.labrin.blockbuster.service;

import com.labrin.blockbuster.model.Productora;
import com.labrin.blockbuster.repository.ProductoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductoraService {

    @Autowired
    private ProductoraRepository productoraRepository;

    public List<Productora> getProductoras(){
        return productoraRepository.findAll();

    }

    public Productora saveProductora(Productora productora){
        return productoraRepository.save(productora);
    }

    public Productora getProductoraId(int id){
        return productoraRepository.findById(id).orElse(null);
    }

    public Productora updateProductora(Productora productora){

        if (!productoraRepository.existsById(productora.getId())){
            return null;
        }
        return productoraRepository.save(productora);
    }

    public void deleteProductora(int id){
        productoraRepository.deleteById(id);
    }






    
}
