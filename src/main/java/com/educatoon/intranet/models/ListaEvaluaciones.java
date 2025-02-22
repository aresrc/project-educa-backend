package com.educatoon.intranet.models;

import jakarta.persistence.*;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "lista_evaluaciones")
public class ListaEvaluaciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "listaEvaluaciones", cascade = CascadeType.ALL)
    private List<Evaluacion> evaluaciones = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "seccion_id")
    private Seccion seccion;

    @OneToOne
    @JoinColumn(name = "estudiante_id")
    private PerfilEstudiante estudiante;

    public float calcularPromedio() {
        if (evaluaciones.isEmpty()) {
            return 0;
        }

        float suma = 0;
        for (Evaluacion eval : evaluaciones) {
            suma += eval.getNota();
        }

        return suma / evaluaciones.size();
    }
}
