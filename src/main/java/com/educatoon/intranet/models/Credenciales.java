package com.educatoon.intranet.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "credenciales")
public class Credenciales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String correo;
    private String contrasenia;

    @OneToOne
    @JoinColumn(name = "perfil_id")
    private Perfil perfil;
}