package com.educatoon.intranet.dto;


import lombok.Data;

import java.util.Date;

@Data
public class PerfilDTO {
    private String nombre;
    private Date fechaNacimiento;
    private String dni;
    private String genero;
    private String telefono;
    private String correo;
    private String tipoPerfil;
}
