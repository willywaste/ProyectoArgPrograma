package com.portfoliogdv.gdv.Service;


import com.portfoliogdv.gdv.Entity.Experiencia;
import com.portfoliogdv.gdv.Repository.RExperencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ServExperiencia {
    @Autowired
    RExperencia rExperencia;

    public List<Experiencia> list() {
     return  rExperencia.findAll();
    }
    public Optional<Experiencia> getOne(int id){
        return rExperencia.findById(id);
    }

    public Optional<Experiencia> getByNombreE(String nombreE){
        return  rExperencia.findByNombreE(nombreE);
    }

    public void save (Experiencia expe){
        rExperencia.save(expe);
    }
    public void delete(int id){
        rExperencia.deleteById(id);
    }
    public boolean existById(int id){
       return rExperencia.existsById(id);
    }
    public boolean existByNombreE(String nombreE){
        return rExperencia.existByNombreE(nombreE);
    }
}
