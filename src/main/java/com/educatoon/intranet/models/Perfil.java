package com.educatoon.intranet.models;

import java.util.Date;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "perfiles")
@Inheritance(strategy = InheritanceType.JOINED)
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    private String dni;
    private String genero;
    private String telefono;
    private String correo;

    @OneToOne(mappedBy = "perfil", cascade = CascadeType.ALL)
    private Credenciales credenciales;
}
