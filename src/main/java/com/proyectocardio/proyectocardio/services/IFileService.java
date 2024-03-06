package com.proyectocardio.proyectocardio.services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.proyectocardio.proyectocardio.models.FileEntity;
import com.proyectocardio.proyectocardio.repositories.FileRepository;
import com.proyectocardio.proyectocardio.resources.ResponseFile;


@Service
public interface IFileService  {

  // Permite almacenar o cargar archivos a la base de datos
  FileEntity store(MultipartFile file) throws IOException;

  // Permite descargar archivos de nuestra base de datos
  Optional<FileEntity> getFile (UUID id) throws FileNotFoundException;

  // Permite consultar la lista de archivos cargados a nuestra base de datos
  //List<ResponseFile> getAllFiles();
}
