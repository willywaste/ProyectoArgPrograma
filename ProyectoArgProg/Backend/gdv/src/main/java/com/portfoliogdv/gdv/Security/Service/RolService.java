package com.portfoliogdv.gdv.Security.Service;

import com.portfoliogdv.gdv.Security.Repository.iRolRepository;
import com.portfoliogdv.gdv.Security.Entity.Rol;
import com.portfoliogdv.gdv.Security.Enums.RolNombre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional

public class RolService {
   @Autowired
    iRolRepository irolRepository;

   public Optional<Rol> getByRolNombre(RolNombre rolNombre){
       return irolRepository.findByRolNombre(rolNombre);
   }

   public void save(Rol rol){
       irolRepository.save(rol);
   }

}
