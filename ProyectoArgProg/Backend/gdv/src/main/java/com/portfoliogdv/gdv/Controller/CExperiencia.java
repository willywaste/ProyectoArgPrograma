package com.portfoliogdv.gdv.Controller;

import com.portfoliogdv.gdv.Dto.DtoExperiencia;
import com.portfoliogdv.gdv.Entity.Experiencia;
import com.portfoliogdv.gdv.Security.Controller.Mensaje;
import com.portfoliogdv.gdv.Service.ServExperiencia;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.PreparedStatement;
import java.util.List;

@RestController
@RequestMapping("explab")
@CrossOrigin(origins = "localhost://4200")
public class CExperiencia {
    @Autowired
    ServExperiencia servExperiencia;

    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list() {


        List<Experiencia> list = servExperiencia.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoExperiencia dtoExp) {
        if (StringUtils.isBlank(dtoExp.getNombreE()))
            return new ResponseEntity(new Mensaje("El campo es obligatorio"), HttpStatus.BAD_REQUEST);

        if (servExperiencia.existByNombreE(dtoExp.getNombreE()))
            return new ResponseEntity(new Mensaje("Experiencia existente"), HttpStatus.BAD_REQUEST);
        Experiencia experiencia = new Experiencia(dtoExp.getNombreE(), dtoExp.getDescripcionE());
        servExperiencia.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia Agregada"), HttpStatus.OK);

    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody DtoExperiencia dtoExp){
    if(!servExperiencia.existById(id))
        return new ResponseEntity(new Mensaje("El Id no existe"), HttpStatus.BAD_REQUEST);

    if(servExperiencia.existByNombreE(dtoExp.getNombreE()) && servExperiencia.getByNombreE(dtoExp.getNombreE()).get().getId()!=id)
        return new ResponseEntity(new Mensaje("Nombre existente"), HttpStatus.BAD_REQUEST);


    if(StringUtils.isBlank(dtoExp.getNombreE()))
        return new ResponseEntity(new Mensaje("Nombre Obliagarotrio"), HttpStatus.BAD_REQUEST);


    Experiencia experiencia = servExperiencia.getOne(id).get();
    experiencia.setNombreE(dtoExp.getNombreE());
    experiencia.setDescripcionE(dtoExp.getDescripcionE());

    servExperiencia.save(experiencia);
    return new ResponseEntity(new Mensaje("Experiencia Actualizada"), HttpStatus.OK);
    }


    public  ResponseEntity<?> delete(@PathVariable("id")int id ){
        if(!servExperiencia.existById(id))
            return new ResponseEntity(new Mensaje("El Id no existe"), HttpStatus.BAD_REQUEST);

      servExperiencia.delete(id);
      return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);
    }
}
