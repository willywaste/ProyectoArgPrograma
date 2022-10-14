package com.portfoliogdv.gdv.Repository;

import com.portfoliogdv.gdv.Entity.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface RExperencia extends JpaRepository<Experiencia, Integer > {
    public Optional<Experiencia> findByNombreE(String nombreE);
    public boolean existByNombreE (String nombreE);
}
