package com.labrin.blockbuster.repository;

import com.labrin.blockbuster.model.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DirectorRepository extends JpaRepository<Director, Integer> {   
}
