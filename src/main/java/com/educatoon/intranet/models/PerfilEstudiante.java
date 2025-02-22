package com.educatoon.intranet.models;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "perfiles_estudiante")
public class PerfilEstudiante extends Perfil {
    private String codigoEstudiante;

    @OneToOne(mappedBy = "estudiante", cascade = CascadeType.ALL)
    private ListaEvaluaciones listaEvaluaciones;

    @OneToOne(mappedBy = "estudiante", cascade = CascadeType.ALL)
    private ListaAsistencias listaAsistencias;

    @ManyToOne
    @JoinColumn(name = "lista_estudiantes_id") // Clave foránea en la tabla perfiles_estudiante
    private ListaEstudiantes listaEstudiantes;
}
