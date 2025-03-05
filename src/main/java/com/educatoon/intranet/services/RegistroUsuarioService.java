package com.educatoon.intranet.services;

import com.educatoon.intranet.dto.RegistroUsuarioDTO;
import com.educatoon.intranet.models.*;
import com.educatoon.intranet.repositories.CredencialesRepository;
import com.educatoon.intranet.repositories.PerfilRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class RegistroUsuarioService {
    private final PerfilRepository perfilRepository;

    private final CredencialesRepository credencialesRepository;

    @Autowired
    public RegistroUsuarioService(PerfilRepository perfilRepository, CredencialesRepository credencialesRepository) {
        this.perfilRepository = perfilRepository;
        this.credencialesRepository = credencialesRepository;
    }

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public String registrarUsuario(RegistroUsuarioDTO dto) {
        // Verificar si el correo ya está registrado
        Optional<Perfil> perfilExistente = perfilRepository.findByCorreo(dto.getCorreo());
        if (perfilExistente.isPresent()) {
            return "El correo ya está en uso.";
        }

        // Crear el perfil según el tipo
        Perfil perfil;
        switch (dto.getTipoPerfil()) { // 🔥 Ahora usa el Enum directamente
            case ESTUDIANTE:
                PerfilEstudiante estudiante = new PerfilEstudiante();
                estudiante.setCodigoEstudiante("EST-" + dto.getDni());
                perfil = estudiante;
                break;
            case PROFESOR:
                PerfilProfesor profesor = new PerfilProfesor();
                profesor.setCurso("Curso Pendiente");
                perfil = profesor;
                break;
            case COORDINADOR:
                perfil = new PerfilCoordinador();
                break;
            case ADMINISTRADOR:
                PerfilAdministrador administrador = new PerfilAdministrador();
                administrador.setNivelAcceso(1);
                administrador.setClaveSeguridad("DEFAULT_KEY");
                perfil = administrador;
                break;
            default:
                return "Tipo de perfil no válido.";
        }

        // Asignar datos generales
        perfil.setNombre(dto.getNombre());
        perfil.setFechaNacimiento(dto.getFechaNacimiento());
        perfil.setDni(dto.getDni());
        perfil.setGenero(dto.getGenero());
        perfil.setTelefono(dto.getTelefono());
        perfil.setCorreo(dto.getCorreo());

        // Guardar perfil en la BD primero
        perfil = perfilRepository.save(perfil);

        // Crear las credenciales con contraseña encriptada
        Credenciales credenciales = new Credenciales();
        credenciales.setCorreo(dto.getCorreo());
        credenciales.setContrasenia(passwordEncoder.encode(dto.getContrasenia()));
        credenciales.setPerfil(perfil);

        // Guardar credenciales
        credencialesRepository.save(credenciales);

        return "Usuario registrado exitosamente como " + dto.getTipoPerfil();
    }

    public boolean actualizarUsuario(String correo, RegistroUsuarioDTO dto) {
        Optional<Perfil> perfilExistente = perfilRepository.findByCorreo(correo);
        if (perfilExistente.isPresent()) {
            Perfil perfil = perfilExistente.get();
            // Asignar datos generales
            perfil.setNombre(dto.getNombre());
            perfil.setFechaNacimiento(dto.getFechaNacimiento());
            perfil.setDni(dto.getDni());
            perfil.setGenero(dto.getGenero());
            perfil.setTelefono(dto.getTelefono());
            perfil.setCorreo(perfilExistente.get().getCorreo());

            switch (dto.getTipoPerfil()) { // 🔥 Ahora usa el Enum directamente
                case ESTUDIANTE:
                    if (perfil instanceof PerfilEstudiante) {
                        ((PerfilEstudiante) perfil).setCodigoEstudiante("EST-" + dto.getDni());
                    }
                    break;
                case PROFESOR:
                    if (perfil instanceof PerfilProfesor) {
                        ((PerfilProfesor) perfil).setCurso("Curso Actualizado");
                    }
                    break;
                case ADMINISTRADOR:
                    if (perfil instanceof PerfilAdministrador) {
                        ((PerfilAdministrador) perfil).setNivelAcceso(2);
                        ((PerfilAdministrador) perfil).setClaveSeguridad("NEW_KEY");
                    }
                    break;
                case COORDINADOR:
                    break;
                default:
                    return false;
            }

            // Guardar perfil en la BD primero
            perfil = perfilRepository.save(perfil);

            Optional<Credenciales> credencialesExistentes = Optional.ofNullable(credencialesRepository.findByCorreo(dto.getCorreo()));
            if (credencialesExistentes.isPresent()) {
                Credenciales credenciales = credencialesExistentes.get();
                credenciales.setContrasenia(passwordEncoder.encode(dto.getContrasenia()));
                credenciales.setPerfil(perfil);
                credencialesRepository.save(credenciales); // 🔥 Realiza el UPDATE;

                perfilRepository.save(perfil);
                return true;
            }
        }
        return false;
    }

    @Transactional
    public boolean eliminarUsuario(String correo) {
        Optional<Perfil> perfilExistente = perfilRepository.findByCorreo(correo);
        if (perfilExistente.isPresent()) {
            Perfil perfil = perfilExistente.get();
            credencialesRepository.deleteByPerfil(perfil);
            perfilRepository.delete(perfil);
            return true;
        }
        return false;
    }
}
