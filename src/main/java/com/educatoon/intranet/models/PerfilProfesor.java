package com.educatoon.intranet.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "perfiles_profesor")
public class PerfilProfesor extends PerfilTrabajador {
    private String curso;
}
