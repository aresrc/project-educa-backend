package com.educatoon.intranet.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "perfiles_trabajador")
@Inheritance(strategy = InheritanceType.JOINED)
public class PerfilTrabajador extends Perfil {
    private String cargo;
    private String departamento;
}
