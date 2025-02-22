package com.educatoon.intranet.repositories;

import com.educatoon.intranet.models.Credenciales;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CredencialesRepository extends JpaRepository<Credenciales, Long> {
    Credenciales findByCorreo(String correo);
}
