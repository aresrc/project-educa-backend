package com.educatoon.intranet.repositories;

import com.educatoon.intranet.models.PerfilEstudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilEstudianteRepository extends JpaRepository<PerfilEstudiante, Long> {
    PerfilEstudiante findByCodigoEstudiante(String codigoEstudiante);
}