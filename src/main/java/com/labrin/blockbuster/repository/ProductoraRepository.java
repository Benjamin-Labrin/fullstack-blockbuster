package com.labrin.blockbuster.repository;

import com.labrin.blockbuster.model.Productora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoraRepository extends JpaRepository<Productora, Integer> {  
}
