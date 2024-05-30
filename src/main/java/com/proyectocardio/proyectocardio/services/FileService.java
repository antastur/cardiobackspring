package com.proyectocardio.proyectocardio.services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.proyectocardio.proyectocardio.models.FileEntity;
import com.proyectocardio.proyectocardio.repositories.FileRepository;
import com.proyectocardio.proyectocardio.resources.ResponseFile;

@Service
public class FileService implements IFileService {


    @Autowired
    private FileRepository fileRepository;
    
    //Metodo para subir un archivo
    @Override
    public FileEntity store(MultipartFile file) throws IOException {

      String fileName = StringUtils.cleanPath(file.getOriginalFilename());
      FileEntity fileEntity= FileEntity.builder()
                .name(fileName)
                .type(file.getContentType())
                .data(file.getBytes())
                .build();
      return fileRepository.save(fileEntity);
    }

    
    //Metodo para bajar un archivo
    @Override
    public Optional<FileEntity> getFile(UUID id) throws FileNotFoundException {
       Optional<FileEntity> file= fileRepository.findById(id);    
            if(file.isPresent()){
                return file;
            }
            throw new FileNotFoundException();

}


/* 
    @Override
    public List<ResponseFile> getAllFiles() {
      
        List<ResponseFile> files = fileRepository.findAll().stream().map(dbFile -> {
            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("api/fileManager/files/")
                    .path(dbFile.getId().toString())
                    .toUriString();
            return ResponseFile.builder()
                    .name(dbFile.getName())
                    .url(fileDownloadUri)
                    .type(dbFile.getType())
                    .size(dbFile.getData().length).build();

        }).collect(Collectors.toList());
        return files;
    } */
    }




