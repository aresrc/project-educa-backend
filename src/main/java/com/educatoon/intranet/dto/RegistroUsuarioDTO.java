package com.educatoon.intranet.dto;

import com.educatoon.intranet.enums.TipoPerfil;
import lombok.Data;
import java.util.Date;

@Data
public class RegistroUsuarioDTO {
    private String nombre;
    private Date fechaNacimiento;
    private String dni;
    private String genero;
    private String telefono;
    private String correo;
    private String contrasenia;
    private TipoPerfil tipoPerfil;
}

