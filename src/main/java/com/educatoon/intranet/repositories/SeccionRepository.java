package com.educatoon.intranet.repositories;

import com.educatoon.intranet.models.Seccion;
import com.educatoon.intranet.enums.EstadoSeccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SeccionRepository extends JpaRepository<Seccion, Long> {
    List<Seccion> findByEstado(EstadoSeccion estado);
}
