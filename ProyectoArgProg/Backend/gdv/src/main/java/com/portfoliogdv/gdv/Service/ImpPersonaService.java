package com.portfoliogdv.gdv.Service;

import com.portfoliogdv.gdv.Entity.Persona;
import com.portfoliogdv.gdv.Interface.IPersonaService;
import com.portfoliogdv.gdv.Repository.IPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImpPersonaService implements IPersonaService {
    @Autowired IPersonaRepository ipersonaRepository;

    @Override
    public List<Persona> getPersona() {
        List <Persona> persona = ipersonaRepository.findAll();
        return persona;
    }

    @Override
    public void savePersona(Persona persona) {
        ipersonaRepository.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
        ipersonaRepository.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
       Persona persona = ipersonaRepository.findById(id).orElse(null);
       return persona;
    }
}
