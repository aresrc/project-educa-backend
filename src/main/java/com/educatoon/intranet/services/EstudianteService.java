package com.educatoon.intranet.services;

import com.educatoon.intranet.models.PerfilEstudiante;
import com.educatoon.intranet.repositories.PerfilEstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EstudianteService {
    private final PerfilEstudianteRepository estudianteRepository;

    @Autowired
    public EstudianteService(PerfilEstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    public List<PerfilEstudiante> findAll() {
        return estudianteRepository.findAll();
    }

    public PerfilEstudiante findByCodigoEstudiante(String codigo) {
        return estudianteRepository.findByCodigoEstudiante(codigo);
    }

    public PerfilEstudiante save(PerfilEstudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }
}
