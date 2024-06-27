package com.proyectocardio.proyectocardio.dtoconverter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import com.proyectocardio.proyectocardio.models.Formacion;
import com.proyectocardio.proyectocardio.models.FormacionDto;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FormacionDTOConverter {

     private final ModelMapper modelMapper;

     public  FormacionDto convertToDto(Formacion formacion){
        return modelMapper.map(formacion,FormacionDto.class);
    }
    }


