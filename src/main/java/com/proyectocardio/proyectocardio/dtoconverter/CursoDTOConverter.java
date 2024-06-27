package com.proyectocardio.proyectocardio.dtoconverter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import com.proyectocardio.proyectocardio.models.Curso;
import com.proyectocardio.proyectocardio.models.CursoDto;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CursoDTOConverter {

   
    private final ModelMapper modelMapper;

    //Metodo para convertir un Curdo en un CursoDto
    public  CursoDto convertToDto(Curso curso){
        return modelMapper.map(curso,CursoDto.class);
    }
}
