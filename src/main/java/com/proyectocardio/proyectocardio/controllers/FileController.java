package com.proyectocardio.proyectocardio.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import com.proyectocardio.proyectocardio.models.FileEntity;
import com.proyectocardio.proyectocardio.services.IFileService;

//Clase que define los endpoints de comunicacion con el Front
//@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class FileController {

    @Autowired
    IFileService fileService;

    @PostMapping("/upload")
    public ResponseEntity<FileEntity> uploadFiles(@RequestParam("files") MultipartFile[] files) {
        String message = "";
        List<String> fileNames = new ArrayList<>();

        try {

            Arrays.asList(files).stream().forEach(file -> {
                fileService.save(file);
                fileNames.add(file.getOriginalFilename());

            });
            message = "Se subieron los archivos " + fileNames;
            return ResponseEntity.status(HttpStatus.OK).body(new FileEntity(message));

        } catch (Exception e) {

            message = "Fallo al subir los archivos";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new FileEntity(message));

        }
    }

    @GetMapping("/files")
    public ResponseEntity<List<FileEntity>> getFiles() {

        List<FileEntity> fileInfos = fileService.loadAll().map(path -> {
            String filename = path.getFileName().toString();
            String url = MvcUriComponentsBuilder
                    .fromMethodName(FileController.class, "getFile", path.getFileName().toString()).build().toString();
            return new FileEntity(filename, url);
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(fileInfos);

    }

    @GetMapping("files/{filename:.+}")
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = fileService.load(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);

    }

    @GetMapping("delete/{filename:.+}")
    public ResponseEntity<FileEntity> deleteFile(@PathVariable String filename) {
        String message = "";
        try {
            message = fileService.deleteFile(filename);
            return ResponseEntity.status(HttpStatus.OK).body(new FileEntity("Archivo borrado"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new FileEntity("Error en el borrado"));
        }

    }

}