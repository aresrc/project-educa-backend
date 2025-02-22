package com.educatoon.intranet.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "perfiles_administrador")
public class PerfilAdministrador extends PerfilTrabajador {
    private int nivelAcceso;
    private String claveSeguridad;
}
