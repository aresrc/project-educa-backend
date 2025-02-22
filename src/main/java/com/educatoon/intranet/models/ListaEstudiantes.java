package com.educatoon.intranet.models;

import jakarta.persistence.*;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "lista_estudiantes")
public class ListaEstudiantes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "listaEstudiantes")
    private List<PerfilEstudiante> estudiantes = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "seccion_id")
    private Seccion seccion;

    public void agregarEstudiante(PerfilEstudiante estudiante) {
        estudiantes.add(estudiante);
    }

    public void eliminarEstudiante(PerfilEstudiante estudiante) {
        estudiantes.remove(estudiante);
    }
}
