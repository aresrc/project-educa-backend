package com.educatoon.intranet.models;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "perfiles_coordinador")
public class PerfilCoordinador extends PerfilTrabajador {
    @ManyToMany
    @JoinTable(
            name = "coordinador_secciones",
            joinColumns = @JoinColumn(name = "coordinador_id"),
            inverseJoinColumns = @JoinColumn(name = "seccion_id")
    )
    private List<Seccion> seccionesAsignadas;
}
