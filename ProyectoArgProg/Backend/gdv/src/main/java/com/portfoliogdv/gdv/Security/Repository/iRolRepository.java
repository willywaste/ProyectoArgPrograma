package com.portfoliogdv.gdv.Security.Repository;

import com.portfoliogdv.gdv.Security.Entity.Rol;
import com.portfoliogdv.gdv.Security.Enums.RolNombre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer> {
 Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
