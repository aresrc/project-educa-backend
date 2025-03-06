# Intranet Project

## Descripción

Este es un proyecto de Spring Boot para gestionar perfiles de usuarios en una intranet. Utiliza Spring Boot, Spring Data JPA y MySQL.

## Estructura de Directorios

```
intranet/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/
│   │   │   │   ├── educatoon/
│   │   │   │   │   ├── controllers/
│   │   │   │   │   │   └── PerfilController.java
│   │   │   │   │   ├── dto/
│   │   │   │   │   │   └── PerfilDTO.java
│   │   │   │   │   ├── models/
│   │   │   │   │   ├── services/
│   │   ├── resources/
│   │   │   ├── application.properties
│   ├── test/
├── HELP.md
├── pom.xml
└── README.md
```

## Prerrequisitos

- Java 17 o superior
- Maven 3.8.1 o superior
- MySQL 8.0 o superior

## Clonar el Repositorio

```bash
git clone https://github.com/aresrc/intranet.git
cd intranet
```

## Configuración de la Base de Datos

Asegúrate de tener una base de datos MySQL corriendo y actualiza las credenciales en el archivo `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/intranet
spring.datasource.username=root
spring.datasource.password=root
```

## Compilar e Instalar

Para compilar e instalar el proyecto, ejecuta los siguientes comandos:

```bash
mvn clean install
```

## Desplegar

Para desplegar la aplicación, ejecuta el siguiente comando:

```bash
mvn spring-boot:run
```

La aplicación estará disponible en http://localhost:8080.

## Endpoints

- `GET /api/profile/{id}`: Obtiene los datos del perfil de usuario por ID.

## Documentación Adicional

Para más información, consulta los siguientes recursos:

- [Documentación oficial de Spring Boot](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)
- [Guía de Spring Data JPA](https://spring.io/guides/gs/accessing-data-jpa/)
- [Guía de Spring Web](https://spring.io/guides/gs/rest-service/)

## Contribuir

Si deseas contribuir a este proyecto, por favor sigue los siguientes pasos:

1. Haz un fork del repositorio.
2. Crea una nueva rama (`git checkout -b feature/nueva-funcionalidad`).
3. Realiza tus cambios y haz commit (`git commit -am 'Añadir nueva funcionalidad'`).
4. Sube tus cambios a tu fork (`git push origin feature/nueva-funcionalidad`).
5. Abre un Pull Request.

## Licencia

Este proyecto está licenciado bajo la Licencia MIT. Consulta el archivo LICENSE para más detalles.