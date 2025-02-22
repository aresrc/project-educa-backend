package com.educatoon.intranet.models;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@Entity
@Table(name = "evaluaciones")
public class Evaluacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigoEstudiante;
    private String nombre;

    @Temporal(TemporalType.DATE)
    private Date fecha;

    private float nota;

    @ManyToOne
    @JoinColumn(name = "lista_evaluaciones_id")
    private ListaEvaluaciones listaEvaluaciones;

    public void verEvaluacion() {
        // Implementación del método
    }
}
