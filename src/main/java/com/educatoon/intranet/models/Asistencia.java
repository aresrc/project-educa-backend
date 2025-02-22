package com.educatoon.intranet.models;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import com.educatoon.intranet.enums.EstadoAsistencia;

@Data
@Entity
@Table(name = "asistencias")
public class Asistencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigoEstudiante;

    @Temporal(TemporalType.DATE)
    private Date fecha;

    @Enumerated(EnumType.STRING)
    private EstadoAsistencia estado;

    @ManyToOne
    @JoinColumn(name = "lista_asistencias_id")
    private ListaAsistencias listaAsistencias;

    public void verAsistencia() {
        // Implementación del método
    }
}
