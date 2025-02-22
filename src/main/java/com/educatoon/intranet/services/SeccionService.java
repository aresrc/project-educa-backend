package com.educatoon.intranet.services;

import com.educatoon.intranet.models.Seccion;
import com.educatoon.intranet.models.ListaEstudiantes;
import com.educatoon.intranet.models.PerfilEstudiante;
import com.educatoon.intranet.repositories.SeccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SeccionService {
    private final SeccionRepository seccionRepository;

    @Autowired
    public SeccionService(SeccionRepository seccionRepository) {
        this.seccionRepository = seccionRepository;
    }

    public List<Seccion> findAll() {
        return seccionRepository.findAll();
    }

    public Seccion findById(Long id) {
        return seccionRepository.findById(id).orElse(null);
    }

    public Seccion save(Seccion seccion) {
        return seccionRepository.save(seccion);
    }

    public void matricularEstudiante(Long seccionId, PerfilEstudiante estudiante) {
        Seccion seccion = findById(seccionId);
        if (seccion != null) {
            ListaEstudiantes lista = seccion.getListaEstudiantes();
            if (lista == null) {
                lista = new ListaEstudiantes();
                lista.setSeccion(seccion);
                seccion.setListaEstudiantes(lista);
            }
            lista.agregarEstudiante(estudiante);
            seccionRepository.save(seccion);
        }
    }
}