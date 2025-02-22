package com.educatoon.intranet.models;


import jakarta.persistence.*;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;
import com.educatoon.intranet.enums.EstadoAsistencia;

@Data
@Entity
@Table(name = "lista_asistencias")
public class ListaAsistencias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "listaAsistencias", cascade = CascadeType.ALL)
    private List<Asistencia> asistencias = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "seccion_id")
    private Seccion seccion;

    @OneToOne
    @JoinColumn(name = "estudiante_id")
    private PerfilEstudiante estudiante;

    public float calcularPorcentajeAsistencia() {
        if (asistencias.isEmpty()) {
            return 0;
        }

        long presentes = asistencias.stream()
                .filter(a -> a.getEstado() == EstadoAsistencia.Presente)
                .count();

        return (float) presentes / asistencias.size() * 100;
    }
}