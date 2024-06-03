package com.proyectocardio.proyectocardio.services;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;
//import com.proyectocardio.proyectocardio.repositories.FileRepository;

@Service
public class FileService implements IFileService {

   // @Autowired
    //private FileRepository fileRepository;

    private final Path root = Paths.get("uploads");

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(root.toFile());

    }

    @Override
    public String deleteFile(String filename) {

        try {
            Boolean delete = Files.deleteIfExists(this.root.resolve(filename));
            return "Borrado";
        } catch (IOException e) {

            return "Error borrando";
        }

    }

    @Override
    public void init() {
        try {
            Files.createDirectory(root);
        } catch (IOException e) {

            throw new RuntimeException("No se puede iniciar el storage");
        }

    }

    @Override
    public Resource load(String filename) {
        Path file;
        Resource resource;
        try {
            file = root.resolve(filename);
            resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("No existe o no se puede leer archivo");
            }
        } catch ( MalformedURLException e ) {
            throw new RuntimeException("Error" + e.getMessage());
        }

    }

    @Override
    public Stream<Path> loadAll() {

        try {
            return Files.walk(root, 1).filter(path -> !path.equals(this.root))
                    .map(this.root::relativize);
        } catch ( IOException e) {
            throw new RuntimeException("No se pueden cargar los archivos");
        }
    }

    @Override
    public void save(MultipartFile file) {

        try {
            Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
        } catch (IOException e) {

            throw new RuntimeException("No se puede copiar el archivo");

        }
    }

}
