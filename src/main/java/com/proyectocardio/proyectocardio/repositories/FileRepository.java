package com.proyectocardio.proyectocardio.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.proyectocardio.proyectocardio.models.FileEntity;

import java.util.UUID;


    



@Repository
public interface FileRepository extends JpaRepository<FileEntity, UUID> {
}

