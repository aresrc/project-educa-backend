package com.educatoon.intranet.models;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import java.util.List;
import com.educatoon.intranet.enums.*;

@Data
@Entity
@Table(name = "secciones")
public class Seccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Universidad universidad;

    @Enumerated(EnumType.STRING)
    private TipoCiclo tipo;

    @Enumerated(EnumType.STRING)
    private TipoTurno turno;

    private int numero;
    private String nombre;

    @Temporal(TemporalType.DATE)
    private Date fechaInicio;

    @Temporal(TemporalType.DATE)
    private Date fechaCierre;

    @Temporal(TemporalType.DATE)
    private Date fechaMatricula;

    @Enumerated(EnumType.STRING)
    private EstadoSeccion estado;

    @OneToOne(mappedBy = "seccion", cascade = CascadeType.ALL)
    private ListaEstudiantes listaEstudiantes;

    @OneToMany(mappedBy = "seccion", cascade = CascadeType.ALL)
    private List<ListaEvaluaciones> listasEvaluaciones;

    @OneToMany(mappedBy = "seccion", cascade = CascadeType.ALL)
    private List<ListaAsistencias> listasAsistencias;

    @ManyToMany(mappedBy = "seccionesAsignadas")
    private List<PerfilCoordinador> coordinadores;
}
